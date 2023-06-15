const express = require("express");
const router = express.Router();
const { getDplkData, getScoreData } = require("./homeController");

router.get("/homepage", getDplkData);
router.put("/score", getScoreData);

module.exports = router;
