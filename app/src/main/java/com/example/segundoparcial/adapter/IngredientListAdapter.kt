package com.example.segundoparcial.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.segundoparcial.databinding.IngredientItemBinding

class IngredientListAdapter(private val ingredients: List<String>) :
    RecyclerView.Adapter<IngredientListAdapter.IngredientViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IngredientViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = IngredientItemBinding.inflate(inflater, parent, false)
        return IngredientViewHolder(binding)
    }

    override fun onBindViewHolder(holder: IngredientViewHolder, position: Int) {
        holder.bind(ingredients[position])
    }

    override fun getItemCount(): Int = ingredients.size

    class IngredientViewHolder(private val binding: IngredientItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(ingredient: String) {
            binding.tvIngredient.text = ingredient
        }
    }
}
