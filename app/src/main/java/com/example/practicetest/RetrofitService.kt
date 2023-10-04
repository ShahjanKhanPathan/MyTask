package com.example.practicetest

import com.example.practicetest.data.Consts
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
class RetrofitService {

    @Singleton
    @Provides
    fun myRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(Consts.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addConverterFactory(SimpleXmlConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun getRetrofitClient(retrofit: Retrofit): ApiInterface {
        return retrofit.create(ApiInterface::class.java)
    }


}