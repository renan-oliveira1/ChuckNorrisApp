package com.example.chucknorrisapp.data.repositories

import com.example.chucknorrisapp.data.models.Joke


interface Repository {
    suspend fun listCategories(): List<String>
    suspend fun getJoke(category: String): Joke
}