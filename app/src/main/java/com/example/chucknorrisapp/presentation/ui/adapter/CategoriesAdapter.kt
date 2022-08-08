package com.example.chucknorrisapp.presentation.ui.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.chucknorrisapp.core.Constans
import com.example.chucknorrisapp.databinding.ItemCategoryBinding
import com.example.chucknorrisapp.presentation.ui.JokeActivity
import java.util.*
import kotlin.coroutines.coroutineContext

class CategoriesAdapter: RecyclerView.Adapter<CategoriesAdapter.ViewHolder>() {

    private var list: List<String> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCategoryBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])

    }

    override fun getItemCount(): Int {
        return list.count()
    }

    fun  updateList(list: List<String>){
        this.list = list
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ItemCategoryBinding): RecyclerView.ViewHolder(binding.root){

        fun bind(item: String){

            binding.tvCategory.text = item.replaceFirstChar {
                if (it.isLowerCase()) it.titlecase(
                    Locale.getDefault()
                ) else it.toString()
            }

            binding.cvItem.setOnClickListener{
                val category = binding.tvCategory.text.toString().lowercase()
                val intent = Intent(binding.cvItem.context, JokeActivity::class.java).apply {
                    putExtra(Constans.EXTRA_CATEGORY_JOKE, category)
                }
                startActivity(binding.cvItem.context, intent, null)
            }
        }

    }
}