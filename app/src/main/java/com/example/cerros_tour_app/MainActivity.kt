package com.example.cerros_tour_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.cerros_tour_app.ui.screens.ActiveReservationsScreen
import com.example.cerros_tour_app.ui.screens.BookingScreen
import com.example.cerros_tour_app.ui.screens.ConfirmationScreen
import com.example.cerros_tour_app.ui.screens.LoginScreen
import com.example.cerros_tour_app.ui.screens.RegisterScreen
import com.example.cerros_tour_app.ui.theme.CerrostourappTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CerrostourappTheme(dynamicColor = false) {
                var currentScreen by remember { mutableStateOf(AppScreen.LOGIN) }
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    when (currentScreen) {
                        AppScreen.LOGIN -> LoginScreen(
                            onLoginClick = { currentScreen = AppScreen.BOOKING },
                            onNavigateToRegister = { currentScreen = AppScreen.REGISTER }
                        )
                        AppScreen.REGISTER -> RegisterScreen(
                            onRegisterSuccess = { currentScreen = AppScreen.BOOKING },
                            onBackToLogin = { currentScreen = AppScreen.LOGIN }
                        )
                        AppScreen.BOOKING -> BookingScreen(
                            onContinue = { currentScreen = AppScreen.CONFIRMATION },
                            onViewReservations = { currentScreen = AppScreen.ACTIVE_RESERVATIONS }
                        )
                        AppScreen.CONFIRMATION -> ConfirmationScreen(
                            onSeeReservations = { currentScreen = AppScreen.ACTIVE_RESERVATIONS },
                            onNewBooking = { currentScreen = AppScreen.BOOKING }
                        )
                        AppScreen.ACTIVE_RESERVATIONS -> ActiveReservationsScreen(
                            onNewBooking = { currentScreen = AppScreen.BOOKING },
                            onBack = { currentScreen = AppScreen.BOOKING }
                        )
                    }
                }
            }
        }
    }
}

private enum class AppScreen {
    LOGIN,
    REGISTER,
    BOOKING,
    CONFIRMATION,
    ACTIVE_RESERVATIONS
}
