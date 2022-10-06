package com.ayd.series.data

import com.ayd.series.models.Avatar
import retrofit2.Response
import javax.inject.Inject

//bazı yeni data requestleri yapabiliriz rempte data source class'ından.
class RemoteDataSource @Inject constructor(  //api interface'i inject ediyoruz. NetworkModule'de provideApiService()'de api'ı belirtmiştik. bu yüzden dagger hilt bunu biliyor.
    private val avatarApi: AvatarApi
){

    suspend fun getAvatar(queries: Map<String,String>): Response<Avatar>{
        return avatarApi.getAvatar(queries)
    }



}