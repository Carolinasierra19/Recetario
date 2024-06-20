package com.example.segundoparcial

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.segundoparcial.adapter.IngredientListAdapter
import com.example.segundoparcial.adapter.RecipeListAdapter
import com.example.segundoparcial.data.Recipe
import com.example.segundoparcial.data.RecipeList
import com.example.segundoparcial.databinding.ActivityRecipeDetailBinding

class RecipeDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRecipeDetailBinding
    private lateinit var ingredientAdapter: IngredientListAdapter
    private lateinit var recommendedAdapter: RecipeListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecipeDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val selectedRecipe = intent.getParcelableExtra<Recipe>("selectedRecipe")
        displayRecipeDetails(selectedRecipe)

        binding.btnBack.setOnClickListener {
            finish()
        }
    }

    private fun displayRecipeDetails(recipe: Recipe?) {
        recipe?.let {
            binding.tvRecipeTitle.text = it.title
            binding.tvRecipeDescription.text = it.description
            initIngredientRecyclerView(it.ingredients)
            initRecommendedRecyclerView()
        }
    }

    private fun initIngredientRecyclerView(ingredients: List<String>) {
        ingredientAdapter = IngredientListAdapter(ingredients)
        binding.rvIngredients.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.rvIngredients.adapter = ingredientAdapter
    }

    private fun initRecommendedRecyclerView() {
        recommendedAdapter = RecipeListAdapter()
        binding.rvRecommended.layoutManager = LinearLayoutManager(this)
        binding.rvRecommended.adapter = recommendedAdapter

        // For simplicity, showing all recipes as recommended recipes
        recommendedAdapter.submitList(RecipeList.listOfRecipes)
    }
}



