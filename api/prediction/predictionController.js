const path = require('path')
const tf = require('@tensorflow/tfjs');

const prediction = async (req, res) => {
  // try {
    // Load model
  //   const modelPath = path.join(__dirname, 'model.json');
  //   const model = await tf.loadLayersModel(`file://${modelPath}`);
    // const model = await tf.loadLayersModel(`model.json`);

    // data
    // [100, 0, 0, 1.38, 2.39, 0.14, -0.81, 23.64, 17.07, 0]

    // input array
    // ['Saham', 'Pasar Uang / Kas', 'Obligasi / SBN / Sukuk', '1 Bulan',
    //    '3 Bulan', '6 Bulan', '1 Tahun', '3 Tahun', '5 Tahun', 'AUM (M)']

  //   const inputData = req.body;
  //   console.log(inputData);

    // Make predictions using the loaded model
    // const inputTensor = tf.tensor([inputData]);
    // const predictions = model.predict(inputTensor);
    // const predictionsArray = await predictions.array();

//     res.json("test");
//   } catch (error) {
//     // error handling
//     console.error("Prediction error:", error);
//     res.status(500).json({ error: "Prediction failed" });
//   }
};

module.exports = {
  prediction
};



module.exports = {
  prediction
};
