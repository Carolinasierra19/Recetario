package com.example.segundoparcial

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.segundoparcial.adapter.RecipeListAdapter
import com.example.segundoparcial.data.Recipe
import com.example.segundoparcial.data.RecipeList
import com.example.segundoparcial.databinding.ActivityMainBinding
import com.example.segundoparcial.databinding.DialogRecipeBinding
import com.example.segundoparcial.viewmodel.RecipeListViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var dialogRecipeBinding: DialogRecipeBinding
    private lateinit var recipeListViewModel: RecipeListViewModel
    private lateinit var adapter: RecipeListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        dialogRecipeBinding = DialogRecipeBinding.inflate(layoutInflater)
        val alertDialogBuilder = AlertDialog.Builder(this)
        alertDialogBuilder.setView(dialogRecipeBinding.root)
        val alertDialog = alertDialogBuilder.create()

        setContentView(binding.root)

        // Initialize the ViewModel
        recipeListViewModel = ViewModelProvider(this).get(RecipeListViewModel::class.java)

        // Initialize the RecyclerView and Adapter
        initRecyclerView()

        // Observe the LiveData from ViewModel
        recipeListViewModel.recipeList.observe(this) { recipes ->
            recipes?.let {
                adapter.submitList(it)
            }
        }

        setListener(alertDialog)
    }

    private fun initRecyclerView() {
        adapter = RecipeListAdapter { recipe ->
            val intent = Intent(this, RecipeDetailActivity::class.java)
            intent.putParcelableArrayListExtra("similarRecipes", getSimilarRecipes(recipe))
            intent.putExtra("selectedRecipe", recipe)
            startActivity(intent)
        }
        binding.rvRecipes.layoutManager = LinearLayoutManager(this)
        binding.rvRecipes.adapter = adapter
    }

    private fun setListener(alertDialog: AlertDialog) {
        binding.fabAddRecipe.setOnClickListener {
            showAlertDialog(alertDialog)
        }
    }

    private fun showAlertDialog(alertDialog: AlertDialog) {
        alertDialog.show()
        dialogRecipeBinding.fabPlus.setOnClickListener {
            val title = addTitleRecipe()
            val description = addDescriptionRecipe()
            val ingredients = addIngredientsRecipe()
            if (title.isNotEmpty() && description.isNotEmpty() && ingredients.isNotEmpty()) {
                recipeListViewModel.addRecipe(title, description, ingredients)
                alertDialog.dismiss()
            }
        }
    }

    private fun addTitleRecipe(): String {
        return dialogRecipeBinding.etTitle.text.toString()
    }

    private fun addDescriptionRecipe(): String {
        return dialogRecipeBinding.etDescription.text.toString()
    }

    private fun addIngredientsRecipe(): List<String> {
        return dialogRecipeBinding.etIngredients.text.toString().split(",").map { it.trim() }
    }

    // Define the getSimilarRecipes function
    private fun getSimilarRecipes(selectedRecipe: Recipe): ArrayList<Recipe> {
        return ArrayList(RecipeList.listOfRecipes.filter { it != selectedRecipe })
    }
}
