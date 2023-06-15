package com.bangkit.riskque.model

import com.google.gson.annotations.SerializedName

data class GetDplkResponse(

    @field:SerializedName("listStory") val listStory: List<Dplk>,

    @field:SerializedName("error") val error: Boolean,

    @field:SerializedName("message") val message: String
)
