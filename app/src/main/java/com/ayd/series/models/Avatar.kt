package com.ayd.series.models

import com.google.gson.annotations.SerializedName


//class Avatar : ArrayList<AvatarItem>()

data class Avatar(
    @SerializedName("AvatarItem")
    val result: List<AvatarItem>
)
