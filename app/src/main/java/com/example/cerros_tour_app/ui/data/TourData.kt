package com.example.cerros_tour_app.data

import com.example.cerros_tour_app.R

val tours = listOf(

    Tour(
        id = 1,
        name = "Santuario de la Peña",
        description = "Un destino rodeado de naturaleza.",
        detailedDescription = "Descubre este destino turístico y disfruta de sus paisajes y atractivos naturales.",
        image = R.drawable.santuario,
        gallery = listOf(R.drawable.santuario, R.drawable.santuario),
        pointsOfInterest = listOf(
            "Paisajes naturales",
            "Recorrido turístico",
            "Zona de fotografías"
        )
    ),

    Tour(
        id = 2,
        name = "Tejo Tradicional",
        description = "Una experiencia cultural y recreativa.",
        detailedDescription = "Conoce el tradicional juego del tejo colombiano y disfruta de una experiencia recreativa.",
        image = R.drawable.tejo,
        gallery = listOf(R.drawable.tejo, R.drawable.tejo),
        pointsOfInterest = listOf(
            "Juego tradicional",
            "Actividad recreativa",
            "Experiencia cultural"
        )
    ),

    Tour(
        id = 3,
        name = "El Balcón del Cielo",
        description = "Admira hermosos paisajes.",
        detailedDescription = "Disfruta de vistas panorámicas y de una experiencia de contacto con la naturaleza.",
        image = R.drawable.balcon,
        gallery = listOf(R.drawable.balcon, R.drawable.balcon),
        pointsOfInterest = listOf(
            "Mirador panorámico",
            "Vistas naturales",
            "Zona de fotografías"
        )
    ),

    Tour(
        id = 4,
        name = "La Cueva del Arco",
        description = "Explora un entorno natural sorprendente.",
        detailedDescription = "Descubre un entorno natural mediante una experiencia de exploración y observación.",
        image = R.drawable.cueva,
        gallery = listOf(R.drawable.cueva, R.drawable.cueva),
        pointsOfInterest = listOf(
            "Formaciones naturales",
            "Recorrido de exploración",
            "Paisajes naturales"
        )
    )
)