package com.example.segundoparcial.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.segundoparcial.data.Recipe
import com.example.segundoparcial.databinding.RecipeItemBinding

class RecipeListViewHolder(
    private val binding: RecipeItemBinding,
    private val onItemClickListener: ((Recipe) -> Unit)?
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(recipe: Recipe) {
        binding.tvTitle.text = recipe.title
        binding.tvDescription.text = recipe.description
        itemView.setOnClickListener {
            onItemClickListener?.invoke(recipe)
        }
    }
}

