package com.example.cerros_tour_app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val Forest = Color(0xFF245B45)
private val Mint = Color(0xFFE8F2EC)
private val Ink = Color(0xFF20312A)
private val Muted = Color(0xFF718078)

@Composable
fun BookingScreen(onContinue: () -> Unit, onViewReservations: () -> Unit) {
    var selectedDate by remember { mutableStateOf("Sáb, 14 Nov") }
    var selectedTime by remember { mutableStateOf("8:00 a. m.") }
    var people by remember { mutableIntStateOf(2) }

    Column(
        modifier = Modifier.fillMaxSize().background(Color(0xFFF7F9F7)).verticalScroll(rememberScrollState())
    ) {
        Column(modifier = Modifier.fillMaxWidth().background(Forest).padding(horizontal = 22.dp, vertical = 24.dp)) {
            Text("CERROS TOUR", color = Color(0xFFCAE3D2), fontSize = 12.sp, fontWeight = FontWeight.Bold, letterSpacing = 2.sp)
            Spacer(Modifier.height(12.dp))
            Text("Planea tu próxima\naventura", color = Color.White, fontSize = 29.sp, lineHeight = 35.sp, fontWeight = FontWeight.Bold)
            Spacer(Modifier.height(7.dp))
            Text("Reserva tu recorrido por los cerros orientales", color = Color(0xFFDCE9E0), fontSize = 13.sp)
        }

        Column(modifier = Modifier.padding(horizontal = 20.dp, vertical = 20.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("Nueva reserva", fontSize = 21.sp, fontWeight = FontWeight.Bold, color = Ink)
                Spacer(Modifier.weight(1f))
                Surface(color = Mint, shape = RoundedCornerShape(50)) {
                    Text("PASO 1 DE 2", modifier = Modifier.padding(horizontal = 11.dp, vertical = 7.dp), color = Forest, fontSize = 10.sp, fontWeight = FontWeight.Bold)
                }
            }
            Spacer(Modifier.height(15.dp))
            Card(shape = RoundedCornerShape(18.dp), colors = CardDefaults.cardColors(containerColor = Color.White), elevation = CardDefaults.cardElevation(2.dp)) {
                Column(Modifier.padding(16.dp)) {
                    Box(Modifier.fillMaxWidth().height(125.dp).background(Color(0xFFDCE9DF), RoundedCornerShape(13.dp)), contentAlignment = Alignment.Center) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text("🌄", fontSize = 39.sp)
                            Text("CERROS ORIENTALES · BOGOTÁ", color = Forest, fontSize = 10.sp, fontWeight = FontWeight.Bold, letterSpacing = 1.sp)
                        }
                    }
                    Spacer(Modifier.height(13.dp))
                    Text("Mirador de Monserrate", color = Ink, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                    Text("Naturaleza, paisaje y una vista inolvidable", color = Muted, fontSize = 12.sp)
                    Spacer(Modifier.height(10.dp))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text("◷  3 horas", color = Muted, fontSize = 12.sp)
                        Spacer(Modifier.width(16.dp))
                        Text("♧  Nivel moderado", color = Muted, fontSize = 12.sp)
                    }
                }
            }

            Spacer(Modifier.height(22.dp))
            SectionTitle("Selecciona una fecha", "Elige el día de tu recorrido")
            Spacer(Modifier.height(11.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                listOf("Vie, 13 Nov", "Sáb, 14 Nov", "Dom, 15 Nov").forEach { date ->
                    ChoiceChip(date, selectedDate == date, Modifier.weight(1f)) { selectedDate = date }
                }
            }

            Spacer(Modifier.height(21.dp))
            SectionTitle("Hora de inicio", "Horarios disponibles")
            Spacer(Modifier.height(11.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(9.dp)) {
                listOf("8:00 a. m.", "10:00 a. m.", "2:00 p. m.").forEach { time ->
                    ChoiceChip(time, selectedTime == time, Modifier.weight(1f)) { selectedTime = time }
                }
            }

            Spacer(Modifier.height(21.dp))
            SectionTitle("Número de personas", "¿Cuántas personas asistirán?")
            Spacer(Modifier.height(11.dp))
            Card(colors = CardDefaults.cardColors(containerColor = Color.White), shape = RoundedCornerShape(14.dp)) {
                Row(Modifier.fillMaxWidth().padding(13.dp), verticalAlignment = Alignment.CenterVertically) {
                    Column(Modifier.weight(1f)) {
                        Text("Participantes", color = Ink, fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
                        Text("Adultos", color = Muted, fontSize = 12.sp)
                    }
                    RoundControl("−", enabled = people > 1) { if (people > 1) people-- }
                    Text("$people", modifier = Modifier.width(38.dp), textAlign = androidx.compose.ui.text.style.TextAlign.Center, color = Ink, fontWeight = FontWeight.Bold, fontSize = 17.sp)
                    RoundControl("+", enabled = people < 12) { if (people < 12) people++ }
                }
            }

            Spacer(Modifier.height(18.dp))
            Card(colors = CardDefaults.cardColors(containerColor = Mint), shape = RoundedCornerShape(14.dp)) {
                Row(Modifier.fillMaxWidth().padding(15.dp), verticalAlignment = Alignment.CenterVertically) {
                    Column(Modifier.weight(1f)) {
                        Text("Total estimado", color = Forest, fontSize = 12.sp)
                        Text("\$${35000 * people}", color = Forest, fontSize = 22.sp, fontWeight = FontWeight.Bold)
                    }
                    Text("\$35.000 / persona", color = Forest, fontSize = 11.sp)
                }
            }

            Spacer(Modifier.height(18.dp))
            Button(onClick = onContinue, modifier = Modifier.fillMaxWidth().height(52.dp), shape = RoundedCornerShape(14.dp), colors = ButtonDefaults.buttonColors(containerColor = Forest)) {
                Text("Continuar con la reserva  →", fontWeight = FontWeight.Bold)
            }
            TextButton(onClick = onViewReservations, modifier = Modifier.fillMaxWidth()) {
                Text("Ver mis reservas", color = Forest, fontWeight = FontWeight.SemiBold)
            }
            Text("* Pantalla demostrativa. No se realiza ningún cobro.", color = Muted, fontSize = 10.sp, modifier = Modifier.align(Alignment.CenterHorizontally).padding(bottom = 18.dp))
        }
    }
}

@Composable
private fun SectionTitle(title: String, subtitle: String) {
    Text(title, color = Ink, fontSize = 16.sp, fontWeight = FontWeight.Bold)
    Text(subtitle, color = Muted, fontSize = 11.sp)
}

@Composable
private fun ChoiceChip(text: String, selected: Boolean, modifier: Modifier = Modifier, onClick: () -> Unit) {
    Surface(modifier = modifier.height(43.dp).clickable { onClick() }, shape = RoundedCornerShape(11.dp), color = if (selected) Forest else Color.White, border = if (selected) null else androidx.compose.foundation.BorderStroke(1.dp, Color(0xFFE0E7E2))) {
        Box(contentAlignment = Alignment.Center) { Text(text, color = if (selected) Color.White else Ink, fontSize = 10.sp, fontWeight = FontWeight.SemiBold) }
    }
}

@Composable
private fun RoundControl(label: String, enabled: Boolean, onClick: () -> Unit) {
    Surface(modifier = Modifier.size(34.dp).clickable(enabled = enabled) { onClick() }, shape = CircleShape, color = if (enabled) Mint else Color(0xFFF1F3F1)) {
        Box(contentAlignment = Alignment.Center) { Text(label, color = if (enabled) Forest else Muted, fontSize = 20.sp, fontWeight = FontWeight.Bold) }
    }
}
