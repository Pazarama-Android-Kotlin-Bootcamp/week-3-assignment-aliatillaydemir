package com.ayd.series.models


import com.google.gson.annotations.SerializedName

data class AvatarItem(
    @SerializedName("bio")
    val bio: Bio,
    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    val image: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("physicalDescription")          //-> gender row layoutta ama diğer kısımları(eye, hair color gibi) overview'a gönderebilirim.
    val physicalDescription: PhysicalDescription,

    @SerializedName("personalInformation")           //-> overview sayfası için
    val personalInformation: PersonalInformation,

    )