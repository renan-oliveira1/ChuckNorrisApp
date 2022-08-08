package com.example.chucknorrisapp.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.chucknorrisapp.domain.usecases.ListCategoriesUseCase
import kotlinx.coroutines.launch

class MainViewModel(): ViewModel() {
    private val listCategoriesUseCase: ListCategoriesUseCase = ListCategoriesUseCase()

    private val _listCategories = MutableLiveData<List<String>>()
    val listCategories: LiveData<List<String>> = _listCategories

    fun getCategoriesList(){
        viewModelScope.launch {
            val resultListCategories = listCategoriesUseCase.execute()
            _listCategories.postValue(resultListCategories)
        }

    }

}