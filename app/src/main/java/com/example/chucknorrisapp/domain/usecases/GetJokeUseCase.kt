package com.example.chucknorrisapp.domain.usecases

import com.example.chucknorrisapp.data.di.RetrofitClient
import com.example.chucknorrisapp.data.models.Joke
import com.example.chucknorrisapp.data.repositories.ChuckRepository
import com.example.chucknorrisapp.data.services.ChuckNorrisService

class GetJokeUseCase {
    private val repository: ChuckRepository = ChuckRepository(
        RetrofitClient.createService().create(ChuckNorrisService::class.java)
    )
    suspend fun getJoke(category: String): Joke = repository.getJoke(category)
}