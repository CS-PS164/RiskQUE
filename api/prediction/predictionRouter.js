const express = require("express");
const router = express.Router();
const { prediction } = require("./predictionController");

router.post("/", prediction);

module.exports = router;
