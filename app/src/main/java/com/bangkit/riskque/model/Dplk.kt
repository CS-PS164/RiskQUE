package com.bangkit.riskque.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Entity(tableName = "dplk")
@Parcelize
data class Dplk(

    @field:SerializedName("photoUrl") val photoUrl: String,

    @field:SerializedName("createdAt") val createdAt: String,

    @field:SerializedName("name") val name: String,

    @field:SerializedName("description") val description: String,

    @PrimaryKey
    @field:SerializedName("id") val id: String,

    @field:SerializedName("lon") val lon: Double,

    @field:SerializedName("lat") val lat: Double
) : Parcelable
