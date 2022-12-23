package com.example.salonvender.model

data class Categories_response(
    val categories: List<Category>,
    val message: String,
    val result: Boolean
)