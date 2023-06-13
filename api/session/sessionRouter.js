const express = require("express");
const router = express.Router();
const { signup } = require("./sessionController");

router.post("/signup", signup);

router.use((req, res, next) => {
  console.info(!req.headers.token);
  if (!req.headers.token) {
    const resErr = {
      rc: "05",
      message: "Masukkan token Anda",
    };
    return res.status(400).json(resErr);
  }
  next();
});

module.exports = router;
