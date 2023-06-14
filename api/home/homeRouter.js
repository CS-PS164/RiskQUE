const express = require("express");
const router = express.Router();
const { getDplkData } = require("./homeController");

router.get("/homepage", getDplkData);

module.exports = router;
