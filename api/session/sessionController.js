const { response } = require("express");
const db = require("./../../config/database");
const sessionValidation = require("./../validation/sessionValidation");

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

    const checkLoginQuery = "SELECT user_id FROM `session` WHERE device_id = ?";
    const isLoggedIn = await db.query(checkLoginQuery, [req.headers.deviceid]);

    if (isLoggedIn[0] != undefined) {
      const resErr = {
        rc: "63",
        message: "Device still logged in",
      };
      return res.status(400).json(resErr);
    }

    let { name, username, password, age, gender } = value;
    const checkUsernameQuery =
      "SELECT username FROM `account` WHERE username = ?";
    const checkUsername = await db.query(checkUsernameStatement, [name]);
    if (checkUsername[0] !== undefined) {
      const resErr = {
        rc: "94",
        message: "username sudah terpakai, silahkan pilih username lain",
      };
      return res.status(400).json(resErr);
    }
  } catch (error) {}
};
