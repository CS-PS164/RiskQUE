const Joi = require("joi").extend(require("@joi/date"));

const sessionValidation = Joi.object({
  nama: Joi.string().min(3).max(35).required().messages({
    "string.base": "Nama harus berupa huruf",
    "string.min": "Masukan nama minimal 5 huruf",
    "string.max": "Masukan nama maximal 35 huruf",
    "string.empty": "Masukan nama anda",
    "any.required": "Masukan nama anda",
  }),
  username: Joi.string().min(5).max(35).required().messages({
    "string.base": "Nama harus berupa huruf",
    "string.min": "Masukan nama minimal 5 huruf",
    "string.max": "Masukan nama maximal 35 huruf",
    "string.empty": "Masukan username anda",
    "any.required": "Masukan username anda",
  }),
  password: Joi.string().min(6).max(35).required().messages({
    "string.base": "password harus berupa huruf",
    "string.min": "Masukan password minimal 6 huruf",
    "string.max": "Masukan password maximal 35 huruf",
    "string.empty": "Masukan password anda",
    "any.required": "Masukan password anda",
  }),
  email: Joi.string().min(6).max(35).required().messages({
    "string.base": "password harus berupa huruf",
    "string.min": "Masukan password minimal 6 huruf",
    "string.max": "Masukan password maximal 35 huruf",
    "string.empty": "Masukan email anda",
    "any.required": "Masukan email anda",
  }),
});

module.exports = sessionValidation;
