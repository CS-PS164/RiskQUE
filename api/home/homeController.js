const db = require("./../../config/database");

const getScoreData = async (req, res) => {
  let { tipe_risiko } = req.body;

  const querySessionStatement =
    "SELECT user_id, token FROM `session` WHERE `token` = ?";
  const querySession = await db.query(querySessionStatement, [
    req.headers.token,
  ]);

  const id = querySession[0].user_id;

  const queryUpdateUser = "UPDATE `users` SET `tipe_risiko` = ? WHERE `id` = ?";
  const updateUser = await db.query(queryUpdateUser, [tipe_risiko, id]);

  const response = {
    rc: "01",
    message: "Success Update User data",
    data: {},
  };
};

const getDplkData = async (req, res) => {
  try {
    const token = req.headers.token;
    const sessionQueryStatement =
      "SELECT `user_id`, `token` FROM `session` WHERE `token` = ?";
    const sessionQuery = await db.query(sessionQueryStatement, [token]);

    const userQueryStatement =
      "SELECT `tipe_risiko` FROM `users` WHERE `id` = ?";
    const userQuery = await db.query(userQueryStatement, [
      sessionQuery[0].user_id,
    ]);

    const dataStatement = "SELECT * FROM `dplk` WHERE `tipe_risiko` = ?";
    const dataQuery = await db.query(dataStatement, [userQuery[0].tipe_risiko]);

    const response = {
      rc: "00",
      message: "Successfully get data",
      data: dataQuery,
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

const getDplkDataById = async (req, res) => {
  try {
  } catch (error) {}
};

module.exports = {
  getDplkData,
  getScoreData,
};
