package com.example.cerros_tour_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.cerros_tour_app.ui.screens.LoginScreen
import com.example.cerros_tour_app.ui.theme.CerrostourappTheme // Fíjate en el nombre exacto

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CerrostourappTheme { // Usamos el nombre correcto del tema
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LoginScreen(
                        onLoginClick = {},
                        onNavigateToRegister = {}
                    )
                }
            }
        }
    }
}