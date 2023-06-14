const express = require("express");
const router = express.Router();
const { signup, login, logout } = require("./sessionController");

router.post("/signup", signup);
router.post("/login", login);

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

router.post("/logout", logout);
module.exports = router;
