package com.tecsup.tarea.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.tecsup.tarea.navigation.Screen
import com.tecsup.tarea.ui.theme.PastelCeleste
import com.tecsup.tarea.ui.theme.PastelLila
import com.tecsup.tarea.ui.theme.PastelPink
import com.tecsup.tarea.viewmodel.CourseViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CourseDetailScreen(navController: NavController, viewModel: CourseViewModel, courseId: Int) {
    val courses by viewModel.catalogState.collectAsState()
    val course = courses.find { it.id == courseId } ?: return

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Detalle ✨", fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, "Atrás")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .verticalScroll(rememberScrollState())
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Surface(
                modifier = Modifier.fillMaxWidth().height(220.dp),
                shape = RoundedCornerShape(32.dp),
                color = PastelCeleste.copy(alpha = 0.3f)
            ) {
                Box(modifier = Modifier.fillMaxSize().background(
                    brush = Brush.verticalGradient(colors = listOf(PastelCeleste, PastelLila))
                ))
            }
            
            Text(text = course.title, style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.ExtraBold, color = PastelPink)
            Text(text = "👩‍🏫 Instructor: ${course.instructor}", style = MaterialTheme.typography.titleMedium, color = Color.Gray)
            
            HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp), color = PastelLila.copy(alpha = 0.3f))
            
            Text(text = "Sobre este curso ✨", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
            Text(text = course.description, style = MaterialTheme.typography.bodyLarge)
            
            Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                CuteBadge(text = "⏱ ${course.duration}", color = PastelCeleste)
                CuteBadge(text = "🌈 ${course.level}", color = PastelLila)
            }

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = { navController.navigate(Screen.Enrollment.createRoute(course.id)) },
                modifier = Modifier.fillMaxWidth().height(60.dp),
                shape = RoundedCornerShape(24.dp),
                colors = ButtonDefaults.buttonColors(containerColor = PastelPink),
                enabled = !course.isEnrolled
            ) {
                Text(if (course.isEnrolled) "Ya eres parte 💖" else "¡Inscribirme ahora! ✨", fontWeight = FontWeight.Bold, style = MaterialTheme.typography.titleMedium)
            }
        }
    }
}
