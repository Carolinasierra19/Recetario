package com.example.segundoparcial.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.segundoparcial.data.Recipe
import com.example.segundoparcial.databinding.RecipeItemBinding

class RecipeListAdapter(private val onItemClickListener: ((Recipe) -> Unit)? = null) :
    ListAdapter<Recipe, RecipeListViewHolder>(RecipeDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RecipeItemBinding.inflate(inflater, parent, false)
        return RecipeListViewHolder(binding, onItemClickListener)
    }

    override fun onBindViewHolder(holder: RecipeListViewHolder, position: Int) {
        val recipe = getItem(position)
        holder.bind(recipe)
    }
}

class RecipeDiffCallback : DiffUtil.ItemCallback<Recipe>() {
    override fun areItemsTheSame(oldItem: Recipe, newItem: Recipe): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Recipe, newItem: Recipe): Boolean {
        return oldItem.title == newItem.title && oldItem.description == newItem.description
    }
}
