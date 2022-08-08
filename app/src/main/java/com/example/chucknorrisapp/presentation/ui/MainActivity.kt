package com.example.chucknorrisapp.presentation.ui

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.example.chucknorrisapp.databinding.ActivityMainBinding
import com.example.chucknorrisapp.presentation.ui.adapter.CategoriesAdapter
import com.example.chucknorrisapp.presentation.viewmodel.MainViewModel
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val binding by lazy{ActivityMainBinding.inflate(layoutInflater)}
    private val adapter by lazy { CategoriesAdapter() }
    private val viewModel by lazy{ MainViewModel()}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //setSupportActionBar(binding.toolbar)
        binding.rvCategories.adapter = adapter

        viewModel.listCategories.observe(this){
            adapter.updateList(it)
        }
        viewModel.getCategoriesList()

    }


}