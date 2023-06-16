from typing import Optional
from fastapi import FastAPI
from pydantic import BaseModel
import numpy as np
import tensorflow as tf
import tensorflow_hub as hub

app = FastAPI()

MODEL = tf.keras.models.load_model("./model.h5", custom_objects = {"KerasLayer" : hub.KerasLayer})
CLASS_NAMES = ['Konservatif', 'Moderat', 'Agresif']

class Dplk(BaseModel):
    saham: Optional[float] = 0
    pasar_uang: Optional[float] = 0
    obligasi: Optional[float] = 0
    bulan_1: Optional[float] = 0
    bulan_3: Optional[float] = 0
    bulan_6: Optional[float] = 0
    tahun_1: Optional[float] = 0
    tahun_3: Optional[float] = 0
    tahun_5: Optional[float] = 0
    aum: Optional[float] = 0

@app.get("/")
def read_root():
    return {"Hello": "World"}

@app.post('/predict/')
async def predict(req: Dplk):

    X_input = list(req.dict().values())
    print(X_input)
    prediction = MODEL.predict(X_input)
    prediction = np.argmax(prediction)

    return {"input": X_input, "prediction": CLASS_NAMES[prediction]}
