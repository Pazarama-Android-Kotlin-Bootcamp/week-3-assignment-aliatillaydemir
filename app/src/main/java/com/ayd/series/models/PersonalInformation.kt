package com.ayd.series.models


import com.google.gson.annotations.SerializedName

data class PersonalInformation(
    @SerializedName("allies")
    val allies: List<String>,
    @SerializedName("enemies")
    val enemies: List<String>,

    @SerializedName("fightingStyles")
    val fightingStyles: List<String>,
    @SerializedName("weaponsOfChoice")
    val weaponsOfChoice: List<String>
)