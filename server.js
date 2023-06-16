const express = require("express");
const cors = require("cors");
const db = require("./config/database");

const PORT = 8000;
const DOMAIN = "127.0.0.1";

const app = express();

const sessionRouter = require("./api/session/sessionRouter");
const homeRouter = require("./api/home/homeRouter");
const predictionRouter = require("./api/prediction/predictionRouter");

app.use(express.json());
app.use(cors());

app.use("/api/session", sessionRouter);
app.use("/api/home", homeRouter);
app.use("/api/prediction", predictionRouter);

app.listen(PORT, DOMAIN, () => {
  console.log(`Server berjalan pada ${DOMAIN}:${PORT}`);
});
