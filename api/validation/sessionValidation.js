const Joi = require("joi").extend(require("@joi/date"));

const sessionValidation = Joi.object({
  name: Joi.string().min(3).max(35).required().messages({
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
    "string.empty": "Masukan nama anda",
    "any.required": "Masukan nama anda",
  }),
  password: Joi.string().min(6).max(35).required().messages({
    "string.base": "password harus berupa huruf",
    "string.min": "Masukan password minimal 6 huruf",
    "string.max": "Masukan password maximal 35 huruf",
    "string.empty": "Masukan password anda",
    "any.required": "Masukan password anda",
  }),
  age: Joi.number().min(1).max(150).required().messages({
    "number.min": "Masukan umur minimal 1 angka",
    "number.max": "Masukan umur maximal 150 angka",
    "any.required": "Masukan umur anda",
  }),
  gender: Joi.string().valid("Male", "Female").required().messages({
    "any.required": "Masukan jenis kelamin anda",
    "any.only": "Masukan jenis kelamin sesuai ketentuan",
  }),
});

module.exports = sessionValidation;
