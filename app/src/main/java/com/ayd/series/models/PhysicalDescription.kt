package com.ayd.series.models


import com.google.gson.annotations.SerializedName

data class PhysicalDescription(
    @SerializedName("eyeColor")
    val eyeColor: String,
    @SerializedName("gender")       //kesin kullanılacak diğer kısımları belki kullanırım.
    val gender: String,
    @SerializedName("hairColor")
    val hairColor: String,
    @SerializedName("skinColor")
    val skinColor: String
)