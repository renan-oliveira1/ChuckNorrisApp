package com.example.chucknorrisapp.data.services

import com.example.chucknorrisapp.data.models.Joke
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ChuckNorrisService {

    @GET("categories")
    fun listCategories(): Call<List<String>>

    @GET("random")
    fun getJoke(@Query("category") category: String): Call<Joke>
}