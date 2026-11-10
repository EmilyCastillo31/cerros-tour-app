
package com.example.cerros_tour_app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.cerros_tour_app.data.tours
import com.example.cerros_tour_app.ui.screens.LoginScreen
import com.example.cerros_tour_app.ui.screens.RegisterScreen
import com.example.cerros_tour_app.ui.screens.HomeScreen
import com.example.cerros_tour_app.ui.screens.DetailScreen

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "login"
    ) {

        // LOGIN
        composable("login") {

            LoginScreen(
                onLoginClick = {
                    navController.navigate("home")
                },
                onNavigateToRegister = {
                    navController.navigate("register")
                }
            )
        }

        // REGISTRO
        composable("register") {

            RegisterScreen(
                onRegisterSuccess = {
                    navController.navigate("home") {
                        popUpTo("login") {
                            inclusive = true
                        }
                    }
                },
                onBackToLogin = {
                    navController.popBackStack()
                }
            )
        }

        // CATÁLOGO
        composable("home") {

            HomeScreen(
                onTourClick = { tourId ->
                    navController.navigate("detail/$tourId")
                }
            )
        }

        // DETALLE
        composable(
            route = "detail/{tourId}",
            arguments = listOf(
                navArgument("tourId") {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->

            val tourId = backStackEntry.arguments
                ?.getInt("tourId")

            val selectedTour = tours.find {
                it.id == tourId
            }

            if (selectedTour != null) {

                DetailScreen(
                    tour = selectedTour,
                    onBack = {
                        navController.popBackStack()
                    }
                )
            }
        }
    }
}
