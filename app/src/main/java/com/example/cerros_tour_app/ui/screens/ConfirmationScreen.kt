package com.example.cerros_tour_app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val ConfirmGreen = Color(0xFF245B45)
private val ConfirmInk = Color(0xFF20312A)
private val ConfirmMuted = Color(0xFF718078)

@Composable
fun ConfirmationScreen(onSeeReservations: () -> Unit, onNewBooking: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize().background(Color(0xFFF7F9F7)).padding(22.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(Modifier.height(22.dp))
        Text("CERROS TOUR", color = ConfirmGreen, fontSize = 12.sp, fontWeight = FontWeight.Bold, letterSpacing = 2.sp)
        Spacer(Modifier.height(40.dp))
        Box(Modifier.size(104.dp).background(Color(0xFFE2F1E7), CircleShape), contentAlignment = Alignment.Center) {
            Text("✓", color = ConfirmGreen, fontSize = 55.sp, fontWeight = FontWeight.Bold)
        }
        Spacer(Modifier.height(23.dp))
        Text("¡Tu aventura está\nreservada!", color = ConfirmInk, fontSize = 28.sp, lineHeight = 34.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center)
        Spacer(Modifier.height(9.dp))
        Text("Hemos preparado los detalles de tu recorrido. ¡Nos vemos en los cerros!", color = ConfirmMuted, fontSize = 13.sp, textAlign = TextAlign.Center, lineHeight = 20.sp)
        Spacer(Modifier.height(27.dp))
        Card(modifier = Modifier.fillMaxWidth(), colors = CardDefaults.cardColors(containerColor = Color.White), shape = RoundedCornerShape(19.dp), elevation = CardDefaults.cardElevation(2.dp)) {
            Column(Modifier.padding(19.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text("RESUMEN DE RESERVA", color = ConfirmMuted, fontSize = 10.sp, fontWeight = FontWeight.Bold, letterSpacing = 1.sp)
                    Spacer(Modifier.weight(1f))
                    Surface(color = Color(0xFFE5F3E9), shape = RoundedCornerShape(30.dp)) { Text("CONFIRMADA", color = ConfirmGreen, fontSize = 9.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(horizontal = 9.dp, vertical = 6.dp)) }
                }
                Spacer(Modifier.height(17.dp))
                Text("Mirador de Monserrate", color = ConfirmInk, fontSize = 19.sp, fontWeight = FontWeight.Bold)
                Text("Cerros Orientales · Bogotá", color = ConfirmMuted, fontSize = 12.sp)
                HorizontalDivider(Modifier.padding(vertical = 17.dp), color = Color(0xFFE9EEEA))
                DetailRow("Código de reserva", "CT-2026-0816")
                DetailRow("Fecha", "Sábado, 14 de noviembre")
                DetailRow("Hora", "8:00 a. m.")
                DetailRow("Participantes", "2 personas")
                DetailRow("Punto de encuentro", "Entrada principal")
                HorizontalDivider(Modifier.padding(vertical = 15.dp), color = Color(0xFFE9EEEA))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text("Total pagado", color = ConfirmInk, fontSize = 13.sp, fontWeight = FontWeight.SemiBold)
                    Spacer(Modifier.weight(1f))
                    Text("\$70.000", color = ConfirmGreen, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                }
            }
        }
        Spacer(Modifier.height(19.dp))
        Row(Modifier.fillMaxWidth().background(Color(0xFFEAF2EC), RoundedCornerShape(13.dp)).padding(13.dp), verticalAlignment = Alignment.CenterVertically) {
            Text("ℹ", color = ConfirmGreen, fontSize = 20.sp)
            Spacer(Modifier.width(10.dp))
            Text("Recuerda llegar 15 minutos antes y llevar ropa cómoda e hidratación.", color = ConfirmGreen, fontSize = 11.sp, lineHeight = 16.sp)
        }
        Spacer(Modifier.weight(1f))
        Button(onClick = onSeeReservations, modifier = Modifier.fillMaxWidth().height(51.dp), shape = RoundedCornerShape(13.dp), colors = ButtonDefaults.buttonColors(containerColor = ConfirmGreen)) { Text("Ver mis reservas", fontWeight = FontWeight.Bold) }
        TextButton(onClick = onNewBooking) { Text("Hacer otra reserva", color = ConfirmGreen) }
    }
}

@Composable
private fun DetailRow(label: String, value: String) {
    Row(Modifier.fillMaxWidth().padding(vertical = 6.dp), verticalAlignment = Alignment.CenterVertically) {
        Text(label, color = ConfirmMuted, fontSize = 12.sp, modifier = Modifier.weight(1f))
        Text(value, color = ConfirmInk, fontSize = 12.sp, fontWeight = FontWeight.SemiBold, textAlign = TextAlign.End)
    }
}
