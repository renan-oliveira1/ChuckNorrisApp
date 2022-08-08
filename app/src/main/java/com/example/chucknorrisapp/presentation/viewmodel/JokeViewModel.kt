package com.example.chucknorrisapp.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.chucknorrisapp.data.models.Joke
import com.example.chucknorrisapp.domain.usecases.GetJokeUseCase
import kotlinx.coroutines.launch

class JokeViewModel: ViewModel() {
    private val jokeUseCase: GetJokeUseCase = GetJokeUseCase()

    private val _joke = MutableLiveData<Joke>()
    val joke: LiveData<Joke> = _joke

    fun getJoke(category: String){
        viewModelScope.launch {
            _joke.postValue(jokeUseCase.getJoke(category))
        }
    }
}