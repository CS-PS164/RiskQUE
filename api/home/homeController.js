const db = require("./../../config/database");

const getScoreData = async (req, res) => {
  let { tipe_risiko } = req.body;

  const querySessionStatement =
    "SELECT user_id, token FROM `session` WHERE `token` = ?";
  const querySession = await db.query(querySessionStatement, [
    req.headers.token,
  ]);

  // if(querySession == undefined) {
  //   const resErr = {
  //     rc: "01",
  //     message: "Success Update User data",
  //   };
  // }

  const id = querySession[0].user_id;
  console.info(id);

  const queryUpdateUser = "UPDATE `users` SET `tipe_risiko` = ? WHERE `id` = ?";
  const updateUser = await db.query(queryUpdateUser, [tipe_risiko, id]);

  const response = {
    rc: "01",
    message: "Success Update User data",
    data: updateUser,
  };

  return res.status(200).json(response);
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

const searchDplk = async (req, res) => {
  try {
    const token = req.headers.token;

    const querySearchStatement =
      "SELECT dplk.dplk, session.token, session.token_exp FROM `dplk` INNER JOIN `session` ON dplk.id = session.user_id WHERE session.token = ?";
    const querySearch = await db.query(querySearchStatement, [token]);

    if (querySearch[0] === undefined) {
      const resErr = {
        rc: "13",
        message: "Data tidak ditemukan",
      };
      return res.status(400).json(resErr);
    }

    if (querySearch[0].token_exp > moment().format("YYYY-MM-DD HH:mm:ss")) {
      const resErr = {
        rc: "63",
        message: "Masa token telah habis",
      };
      return res.status(400).json(resErr);
    }

    let dplkName = "%" + (req.body.name ?? "") + "%";

    const queryDplkStatement = "SELECT `dplk` FROM `dplk` WHERE `dplk` LIKE ?";
    const queryDplk = await db.query(queryDplkStatement, [
      dplkName.toLowerCase(),
    ]);
    if (getMeal[0] !== undefined) {
      const response = {
        rc: "00",
        message: "Berhasil get data",
        data: queryDplk,
      };
      return res.status(200).json(response);
    } else {
      const response = {
        rc: "00",
        message: "Berhasil get data",
        data: [],
      };
      return res.status(200).json(response);
    }
  } catch (error) {}
};

module.exports = {
  getDplkData,
  getScoreData,
  searchDplk,
};
