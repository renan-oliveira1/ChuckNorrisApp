package com.example.chucknorrisapp.domain.usecases

import com.example.chucknorrisapp.data.di.RetrofitClient
import com.example.chucknorrisapp.data.repositories.ChuckRepository
import com.example.chucknorrisapp.data.services.ChuckNorrisService

class ListCategoriesUseCase() {
    private val repository: ChuckRepository = ChuckRepository(
        RetrofitClient.createService().create(ChuckNorrisService::class.java)
    )

    suspend fun execute(): List<String> = repository.listCategories()

}