package com.example.segundoparcial.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.segundoparcial.data.Recipe
import com.example.segundoparcial.data.RecipeList

class RecipeListViewModel : ViewModel() {
    private val _recipeList = MutableLiveData<List<Recipe>>()
    val recipeList: LiveData<List<Recipe>> = _recipeList

    init {
        _recipeList.value = RecipeList.listOfRecipes
    }

    fun addRecipe(title: String, description: String, ingredients: List<String>) {
        val recipe = Recipe(title, description, ingredients)
        val updatedList = _recipeList.value.orEmpty().toMutableList()
        updatedList.add(recipe)
        _recipeList.value = updatedList
    }
}

