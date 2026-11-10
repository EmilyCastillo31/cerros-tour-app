package com.example.cerros_tour_app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val ReservationsGreen = Color(0xFF245B45)
private val ReservationsInk = Color(0xFF20312A)
private val ReservationsMuted = Color(0xFF718078)

@Composable
fun ActiveReservationsScreen(onNewBooking: () -> Unit, onBack: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize().background(Color(0xFFF7F9F7)).verticalScroll(rememberScrollState())) {
        Column(Modifier.fillMaxWidth().background(ReservationsGreen).padding(horizontal = 22.dp, vertical = 25.dp)) {
            Text("CERROS TOUR", color = Color(0xFFCAE3D2), fontSize = 11.sp, fontWeight = FontWeight.Bold, letterSpacing = 2.sp)
            Spacer(Modifier.height(13.dp))
            Text("Mis reservas", color = Color.White, fontSize = 28.sp, fontWeight = FontWeight.Bold)
            Text("Organiza y consulta tus próximas aventuras", color = Color(0xFFDCE9E0), fontSize = 12.sp)
        }
        Column(Modifier.padding(20.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("Próximos recorridos", color = ReservationsInk, fontSize = 19.sp, fontWeight = FontWeight.Bold)
                Spacer(Modifier.weight(1f))
                Surface(color = Color(0xFFE5F3E9), shape = RoundedCornerShape(30.dp)) { Text("2 ACTIVAS", color = ReservationsGreen, fontSize = 9.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(horizontal = 10.dp, vertical = 7.dp)) }
            }
            Spacer(Modifier.height(14.dp))
            ReservationCard("Mirador de Monserrate", "Sábado, 16 de noviembre", "8:00 a. m.", "2 personas", "CT-2026-0816", "CONFIRMADA", "🌄")
            Spacer(Modifier.height(13.dp))
            ReservationCard("Santuario de la Peña", "Domingo, 22 de noviembre", "9:30 a. m.", "3 personas", "CT-2026-0824", "PENDIENTE", "🌿")
            Spacer(Modifier.height(22.dp))
            Text("Historial", color = ReservationsInk, fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Spacer(Modifier.height(10.dp))
            Card(colors = CardDefaults.cardColors(containerColor = Color.White), shape = RoundedCornerShape(15.dp)) {
                Row(Modifier.fillMaxWidth().padding(15.dp), verticalAlignment = Alignment.CenterVertically) {
                    Box(Modifier.size(43.dp).background(Color(0xFFEAF2EC), RoundedCornerShape(12.dp)), contentAlignment = Alignment.Center) { Text("⛰", fontSize = 22.sp) }
                    Spacer(Modifier.width(12.dp))
                    Column(Modifier.weight(1f)) {
                        Text("Quebrada La Vieja", color = ReservationsInk, fontWeight = FontWeight.SemiBold, fontSize = 13.sp)
                        Text("Realizada · 02 Nov 2026", color = ReservationsMuted, fontSize = 11.sp)
                    }
                    Text("Completada", color = ReservationsGreen, fontSize = 10.sp, fontWeight = FontWeight.Bold)
                }
            }
            Spacer(Modifier.height(22.dp))
            Button(onClick = onNewBooking, modifier = Modifier.fillMaxWidth().height(51.dp), shape = RoundedCornerShape(13.dp), colors = ButtonDefaults.buttonColors(containerColor = ReservationsGreen)) { Text("＋  Crear nueva reserva", fontWeight = FontWeight.Bold) }
            TextButton(onClick = onBack, modifier = Modifier.fillMaxWidth()) { Text("Volver a la reserva", color = ReservationsGreen) }
            Text("Los datos mostrados son de ejemplo para la presentación visual.", color = ReservationsMuted, fontSize = 10.sp, modifier = Modifier.align(Alignment.CenterHorizontally).padding(bottom = 18.dp))
        }
    }
}

@Composable
private fun ReservationCard(title: String, date: String, time: String, people: String, code: String, status: String, emoji: String) {
    Card(colors = CardDefaults.cardColors(containerColor = Color.White), shape = RoundedCornerShape(17.dp), elevation = CardDefaults.cardElevation(2.dp)) {
        Column(Modifier.padding(15.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(Modifier.size(47.dp).background(Color(0xFFEAF2EC), RoundedCornerShape(13.dp)), contentAlignment = Alignment.Center) { Text(emoji, fontSize = 25.sp) }
                Spacer(Modifier.width(11.dp))
                Column(Modifier.weight(1f)) {
                    Text(title, color = ReservationsInk, fontSize = 15.sp, fontWeight = FontWeight.Bold)
                    Text("Cerros Orientales · Bogotá", color = ReservationsMuted, fontSize = 10.sp)
                }
                Surface(color = if (status == "CONFIRMADA") Color(0xFFE5F3E9) else Color(0xFFFFF2D9), shape = RoundedCornerShape(30.dp)) {
                    Text(status, color = if (status == "CONFIRMADA") ReservationsGreen else Color(0xFF9A6A13), fontSize = 8.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(horizontal = 8.dp, vertical = 6.dp))
                }
            }
            HorizontalDivider(Modifier.padding(vertical = 13.dp), color = Color(0xFFE9EEEA))
            Text("▦  $date", color = ReservationsInk, fontSize = 12.sp)
            Spacer(Modifier.height(7.dp))
            Row {
                Text("◷  $time", color = ReservationsMuted, fontSize = 11.sp)
                Spacer(Modifier.width(18.dp))
                Text("♙  $people", color = ReservationsMuted, fontSize = 11.sp)
            }
            Spacer(Modifier.height(12.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("Código: $code", color = ReservationsMuted, fontSize = 10.sp)
                Spacer(Modifier.weight(1f))
                Text("Ver detalles  ›", color = ReservationsGreen, fontSize = 10.sp, fontWeight = FontWeight.Bold)
            }
        }
    }
}
