import * as tf from "@tensorflow/tfjs-node";

const prediction = async (req, res) => {
  const model = await tf.loadLayersModel("file://model.json");
};
