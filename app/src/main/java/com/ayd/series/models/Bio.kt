package com.ayd.series.models


import com.google.gson.annotations.SerializedName

data class Bio(
    @SerializedName("ages")
    val ages: List<String>,
    @SerializedName("born")  //dursun, belki kullanırım
    val born: String,
    @SerializedName("died")  //belki kullanırım
    val died: List<String>,
    @SerializedName("nationality")
    val nationality: String
)