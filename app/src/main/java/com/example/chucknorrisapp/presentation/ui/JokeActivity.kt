package com.example.chucknorrisapp.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.chucknorrisapp.core.Constans
import com.example.chucknorrisapp.databinding.ActivityJokeBinding
import com.example.chucknorrisapp.presentation.viewmodel.JokeViewModel
import java.util.*

class JokeActivity : AppCompatActivity() {
    private val binding by lazy{ActivityJokeBinding.inflate(layoutInflater)}
    private val viewModel by lazy{JokeViewModel()}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        viewModel.joke.observe(this){
            binding.tvJoke.text = it.value
        }

        binding.ivBack.setOnClickListener{
            finish()
        }

        loadCategory()
    }

    private fun loadCategory(){
        val category = intent.getStringExtra(Constans.EXTRA_CATEGORY_JOKE)

        if (category != null) {
            binding.tvCategory.text = category.replaceFirstChar {
                if (it.isLowerCase()) it.titlecase(
                    Locale.getDefault()
                ) else it.toString()
            }
            viewModel.getJoke(category)
        }
    }

}