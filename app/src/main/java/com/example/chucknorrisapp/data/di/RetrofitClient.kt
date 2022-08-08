package com.example.chucknorrisapp.data.di

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private lateinit var INSTANCE: Retrofit

    fun createService(): Retrofit {
        if(!::INSTANCE.isInitialized){
            INSTANCE = Retrofit.Builder()
                .baseUrl("https://api.chucknorris.io/jokes/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return INSTANCE
    }

}