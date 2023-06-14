const express = require("express");
const db = require("./../../config/database");
const sessionValidation = require("./../validation/sessionValidation");
const helper = require("./../helper/index");
const moment = require("moment");

const signup = async (req, res) => {
  try {
    const checkInput = sessionValidation.validate(req.body);
    const { value, error } = checkInput;

    if (error) {
      const response = {
        rc: "05",
        message: error.details[0].message,
      };
      return res.status(400).json(response);
    }

    let { username, email, password, nama } = value;
    const checkUsernameQuery =
      "SELECT username FROM `users` WHERE username = ?";
    const checkUsername = await db.query(checkUsernameQuery, [username]);
    if (checkUsername[0] !== undefined) {
      const resErr = {
        rc: "94",
        message: "username sudah terpakai, silahkan pilih username lain",
      };
      return res.status(400).json(resErr);
    }

    const dateNow = moment();

    // const created_at = dateNow.unix();
    const user_id = helper.generateUserid();
    password = helper.encryption(password);
    nama = nama.replace(/\w+/g, function (w) {
      return w[0].toUpperCase() + w.slice(1).toLowerCase();
    });

    const token = helper.generateToken();
    const token_exp = dateNow.add(1, "years").format("YYYY-MM-DD HH:mm:ss");

    const insertUserStatement =
      "INSERT INTO `users` (`id`, `username`, `email`, `password`, `nama`, `role_id`) VALUES(?,?,?,?,?,?)";

    const insertTokenStatement =
      "INSERT INTO `session`(`user_id`, `token`, `token_exp`) VALUES(?,?,?)";
    const connection = await db.getDb();

    try {
      await connection.beginTransaction();
      await connection.query(insertUserStatement, [
        user_id,
        username,
        email,
        password,
        nama,
        2,
      ]);

      await connection.query(insertTokenStatement, [user_id, token, token_exp]);
      await connection.commit();
    } catch (error) {
      const resErr = {
        rc: "91",
        message: "Gagal menyimpan ke database!",
      };

      await connection.rollback();
      console.info(error);
      return res.status(400).json(resErr);
    }

    const response = {
      rc: "00",
      message: "Berhasil membuat akun",
      data: {
        token,
        token_exp,
      },
    };
    return res.status(200).json(response);
  } catch (error) {
    const resErr = {
      rc: "30",
      message: "false",
    };
    console.info(error);
    return res.status(400).json(resErr);
  }
};

const login = async (req, res) => {
  try {
    let isLogin = 0;
    let { username, password } = req.body;
    if (username === undefined || password === undefined) {
      const resErr = {
        rc: "05",
        message: "Masukan username dan password",
      };
      return res.status(400).json(resErr);
    }

    const searchLogin =
      "SELECT users.id, users.password FROM `users` WHERE users.username = ?";
    const search = await db.query(searchLogin, [username]);

    if (search[0] === undefined) {
      const resErr = {
        rc: "14",
        message: "Akun tidak ditemukan",
      };
      return res.status(400).json(resErr);
    }

    const searchSessionStatement =
      "SELECT `user_id`, `token` FROM `session` WHERE token=?";
    const searchSession = await db.query(searchSessionStatement, [
      req.headers.token,
    ]);

    if (searchSession[0] !== undefined) {
      isLogin = 1;
    }

    const decryptPassword = helper.decryption(search[0].password);
    if (decryptPassword !== password) {
      const resErr = {
        rc: "55",
        message: "Password salah",
      };
      return res.status(400).json(resErr);
    }

    const dateNow = moment();
    const token = helper.generateToken();
    const token_exp = dateNow.add(1, "years").format("YYYY-MM-DD HH:mm:ss");

    if (isLogin == 0) {
      const createUpdateTokenStatement =
        "INSERT INTO `session`(`user_id`, `token`, `token_exp`) VALUES (?, ?, ?)";
      const createupdateToken = await db.query(createUpdateTokenStatement, [
        search[0].user_id,
        token,
        token_exp,
      ]);

      if (createupdateToken.affectedRows == 0) {
        const resErr = {
          rc: "91",
          message: "Gagal login",
        };
        return res.status(400).json(resErr);
      }
    } else {
      const createUpdateTokenStatement =
        "UPDATE `session` SET `user_id`=?,`token`=?,`token_exp`=? WHERE user_id=?";
      const createupdateToken = await db.query(createUpdateTokenStatement, [
        search[0].user_id,
        token,
        token_exp,
        search[0].user_id,
      ]);

      if (createupdateToken.affectedRows == 0) {
        const resErr = {
          rc: "91",
          message: "Gagal login",
        };
        return res.status(400).json(resErr);
      }
    }

    const response = {
      rc: "00",
      message: "Berhasil login",
      data: {
        token,
        token_exp,
      },
    };
    return res.status(200).json(response);
  } catch (error) {
    const resErr = {
      rc: "30",
      message: "Kesalahan umum",
    };
    console.info(error);
    return res.status(400).json(resErr);
  }
};

const logout = async (req, res) => {
  try {
    const token = req.headers.token;

    const logoutStatement = "DELETE FROM `session` WHERE token=?";
    await db.query(logoutStatement, token);

    const response = {
      rc: "00",
      message: "Berhasil logout",
    };
    return res.status(400).json(response);
  } catch (error) {
    const resErr = {
      rc: "30",
      message: "Kesalahan umum",
    };
    console.info(error);
    return res.status(400).json(resErr);
  }
};

module.exports = {
  signup,
  login,
  logout,
};
