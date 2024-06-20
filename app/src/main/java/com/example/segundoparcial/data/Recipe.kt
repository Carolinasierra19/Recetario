package com.example.segundoparcial.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Recipe(
    val title: String,
    val description: String,
    val ingredients: List<String>
) : Parcelable
