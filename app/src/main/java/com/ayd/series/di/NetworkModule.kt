package com.ayd.series.di

import com.ayd.series.data.AvatarApi
import com.ayd.series.util.Constants.Companion.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {


    @Singleton
    @Provides
    fun provideHttpClient(): OkHttpClient{           //39. satırdaki retrofiti instance ederkenki clienti provide ediyoruz.
        return OkHttpClient.Builder()
            .readTimeout(10,TimeUnit.SECONDS)
            .connectTimeout(10,TimeUnit.SECONDS)
            .build()
    }

    @Singleton
    @Provides                                              //40. satırdaki gson converter factory'i hazırlıyoruz
    fun provideConvertorFactory(): GsonConverterFactory{  //converter factory'i yazıyoruz(3.)
        return GsonConverterFactory.create()
    }


    @Singleton
    @Provides
    fun provideRetrofitInstance(         //provide ettiğimiz retrofiti instance ediyoruz(2.)
        okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ): Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(gsonConverterFactory)
            .build()
    }

    @Singleton                        //retrofit'i provide ediyoruz (1.)
    @Provides
    fun provideApiService(retrofit: Retrofit): AvatarApi {
        return retrofit.create(AvatarApi::class.java)
    }

}