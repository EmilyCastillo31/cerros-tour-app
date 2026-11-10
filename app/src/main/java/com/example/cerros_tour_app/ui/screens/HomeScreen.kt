
package com.example.cerros_tour_app.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.cerros_tour_app.data.tours
import com.example.cerros_tour_app.ui.components.TourCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onTourClick: (Int) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Cerros Tour 🌿")
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
                Text(
                    text = "Descubre nuestros destinos",
                    style = MaterialTheme.typography.headlineSmall
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Explora los mejores recorridos y miradores.",
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            items(tours) { tour ->

                TourCard(
                    tour = tour,
                    onClick = {
                        onTourClick(tour.id)
                    }
                )
            }
        }
    }
}
