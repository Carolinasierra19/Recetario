package com.example.segundoparcial.data

object RecipeList {
    val listOfRecipes = mutableListOf(
        Recipe("Spaghetti Carbonara", "Classic Italian pasta dish made with eggs, cheese, pancetta, and pepper", listOf("Spaghetti", "Eggs", "Cheese", "Pancetta", "Pepper")),
        Recipe("Chicken Curry", "A flavorful Indian dish made with chicken, spices, and coconut milk", listOf("Chicken", "Spices", "Coconut Milk", "Onions", "Garlic")),
        Recipe("Beef Stew", "A hearty stew made with beef, vegetables, and potatoes", listOf("Beef", "Carrots", "Potatoes", "Onions", "Celery")),
        Recipe("Caesar Salad", "A classic salad made with romaine lettuce, croutons, and Caesar dressing", listOf("Romaine Lettuce", "Croutons", "Caesar Dressing", "Parmesan Cheese")),
        Recipe("Pancakes", "Fluffy pancakes made with flour, eggs, milk, and butter", listOf("Flour", "Eggs", "Milk", "Butter", "Maple Syrup")),
        Recipe("Tacos", "Mexican dish made with tortillas, meat, cheese, and various toppings", listOf("Tortillas", "Meat", "Cheese", "Lettuce", "Tomatoes")),
        Recipe("Sushi", "Japanese dish made with vinegared rice, seafood, and vegetables", listOf("Rice", "Seafood", "Nori", "Vegetables", "Soy Sauce")),
        Recipe("Lasagna", "Italian dish made with layers of pasta, meat, cheese, and tomato sauce", listOf("Pasta", "Meat", "Cheese", "Tomato Sauce", "Garlic")),
        Recipe("Chocolate Cake", "Rich chocolate cake made with cocoa, flour, sugar, and eggs", listOf("Cocoa", "Flour", "Sugar", "Eggs", "Butter")),
        Recipe("Omelette", "Egg dish made with beaten eggs, cheese, and vegetables", listOf("Eggs", "Cheese", "Vegetables", "Butter", "Salt"))
    )

    fun addRecipe(recipe: Recipe) {
        listOfRecipes.add(recipe)
    }
}

