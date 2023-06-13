const { response } = require("express");
const db = require("./../../config/database");
const sessionValidation = require("./../validation/sessionValidation");
const helper = require("./../helper/index");

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

    let { email, username, password } = value;
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

    const created_at = dateNow.unix();
    const user_id = helper.generateUserid();
    password = helper.encryption(password);
    name = name.replace(/\w+/g, function (w) {
      return w[0].toUpperCase() + w.slice(1).toLowerCase();
    });

    const token = helper.generateToken();
    const token_exp = dateNow.add(1, "years").format("YYYY-MM-DD HH:mm:ss");

    const insertUserStatement =
      "INSERT INTO `users(`id`, `username`, `email`, `password`, `nama`) VALUES(?,?,?,?,?)";

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
  } catch (error) {}
};

module.exports = {
  signup,
};
