const express = require("express");
const tfn = require('@tensorflow/tfjs-node');
const router = express.Router();
const { signup, login } = require("./sessionController");
const { prediction } = require("../prediction");

router.post("/signup", signup);
router.post("/login", login);

router.post("/prediction", (req, res) => {
  const modelPath = 'model.json';
  let model;

  async function loadModel() {
    try {
      model = await tfn.loadLayersModel(`file://${modelPath}`);
      console.log('Model loaded successfully!');
    } catch (err) {
      console.error('Error loading the model:', err);
    }
  }

  loadModel();
  const result = prediction(model, req.body);

  res.send(result);
});


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
