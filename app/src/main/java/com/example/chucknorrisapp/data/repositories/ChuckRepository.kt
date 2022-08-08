package com.example.chucknorrisapp.data.repositories

import com.example.chucknorrisapp.data.models.Joke
import com.example.chucknorrisapp.data.services.ChuckNorrisService
import retrofit2.*

class ChuckRepository(private val service: ChuckNorrisService): Repository {


    override suspend fun listCategories(): List<String> {

        return service.listCategories().await()
    }


    override suspend fun getJoke(category: String): Joke {
        try {
            return service.getJoke(category).await()
        }catch (e: Exception){
            throw Exception(e.message)
        }
    }


}