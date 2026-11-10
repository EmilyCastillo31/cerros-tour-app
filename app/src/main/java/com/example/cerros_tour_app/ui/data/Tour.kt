package com.example.cerros_tour_app.data

data class Tour(
    val id: Int,
    val name: String,
    val description: String,
    val detailedDescription: String,
    val image: Int,
    val gallery: List<Int>,
    val pointsOfInterest: List<String>
)