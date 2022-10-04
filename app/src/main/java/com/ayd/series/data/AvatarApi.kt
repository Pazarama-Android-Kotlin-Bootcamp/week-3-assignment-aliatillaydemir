package com.ayd.series.data

import com.ayd.series.models.Avatar
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface AvatarApi {  //bu interface request içindir.

    @GET("/avatar/characters")
    suspend fun getAvatar(              //coroutines kullanacağımız için suspend olmalı. Main değil, background threadde çalışmalı çünkü.
        @QueryMap queries: Map<String,String>  //-> tek queryim var o yüzden ihtiyacım yok ama olsaydı böyle kullanıyorduk.
    ):Response<Avatar>

}