const db = require("./../../config/database");

const getDplkData = async (req, res) => {
  try {
    const dataStatement = "SELECT * FROM `dplk`";

    const datas = await db.query(dataStatement);

    const response = {
      rc: "00",
      message: "Successfully get data",
      data: datas,
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
};
