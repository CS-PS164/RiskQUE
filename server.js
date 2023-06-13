const express = require("express");
const cors = require("cors");

const PORT = 8000;
const DOMAIN = "127.0.0.1";

const app = express();

const sessionRouter = require("./api/session/sessionRouter");

app.use(express.json());
app.use(cors());

app.use("/api/session", sessionRouter);

app.listen(PORT, DOMAIN, () => {
  console.log(`Server berjalan pada ${DOMAIN}:${PORT}`);
});
