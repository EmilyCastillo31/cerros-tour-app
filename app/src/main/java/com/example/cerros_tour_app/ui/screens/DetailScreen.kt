
package com.example.cerros_tour_app.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.cerros_tour_app.data.Tour

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    tour: Tour,
    onBack: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(tour.name) },
                navigationIcon = {
                    TextButton(onClick = onBack) {
                        Text("Volver")
                    }
                }
            )
        }
    ) { paddingValues ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            item {
                Image(
                    painter = painterResource(tour.image),
                    contentDescription = tour.name,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(230.dp),
                    contentScale = ContentScale.Crop
                )
            }

            item {
                Text(
                    text = tour.name,
                    style = MaterialTheme.typography.headlineMedium
                )
            }

            item {
                Text(
                    text = "Sobre este destino",
                    style = MaterialTheme.typography.titleLarge
                )

                Text(
                    text = tour.detailedDescription,
                    style = MaterialTheme.typography.bodyLarge
                )
            }

            item {
                Text(
                    text = "Galería de imágenes",
                    style = MaterialTheme.typography.titleLarge
                )
            }

            item {
                LazyRow(
                    horizontalArrangement =
                        Arrangement.spacedBy(12.dp)
                ) {
                    items(tour.gallery) { image ->

                        Image(
                            painter = painterResource(image),
                            contentDescription = "Imagen del destino",
                            modifier = Modifier
                                .width(220.dp)
                                .height(150.dp),
                            contentScale = ContentScale.Crop
                        )
                    }
                }
            }

            item {
                Text(
                    text = "Puntos de interés",
                    style = MaterialTheme.typography.titleLarge
                )
            }

            items(tour.pointsOfInterest) { point ->

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Text(
                        text = "📍 $point",
                        modifier = Modifier.padding(16.dp),
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }
        }
    }
}
