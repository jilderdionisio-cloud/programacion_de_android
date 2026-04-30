package com.tecsup.tarea.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.tecsup.tarea.navigation.Screen
import com.tecsup.tarea.ui.theme.PastelLila
import com.tecsup.tarea.ui.theme.PastelPink
import com.tecsup.tarea.viewmodel.CourseViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EnrollmentScreen(navController: NavController, viewModel: CourseViewModel, courseId: Int) {
    val courses by viewModel.catalogState.collectAsState()
    val course = courses.find { it.id == courseId } ?: return

    var dni by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Casi listo ✨", fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, "Atrás")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier.padding(padding).fillMaxSize().verticalScroll(rememberScrollState()).padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(text = "¡Qué emoción! 💖", style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.ExtraBold, color = PastelPink)
            Text(text = "Te estás uniendo a: ${course.title}", style = MaterialTheme.typography.bodyLarge)

            HorizontalDivider(color = PastelLila.copy(alpha = 0.3f))

            CuteTextField(value = dni, onValueChange = { if (it.length <= 8) dni = it }, label = "Tu DNI")
            CuteTextField(value = name, onValueChange = { name = it }, label = "Tu Nombre Completo")

            Spacer(modifier = Modifier.height(32.dp))

            Button(
                onClick = { 
                    viewModel.enroll(courseId)
                    navController.navigate(Screen.MyCourses.route) {
                        popUpTo(Screen.Courses.route) { inclusive = false }
                    }
                },
                modifier = Modifier.fillMaxWidth().height(56.dp),
                shape = RoundedCornerShape(24.dp),
                colors = ButtonDefaults.buttonColors(containerColor = PastelLila),
                enabled = dni.length >= 8 && name.isNotEmpty()
            ) {
                Text("¡Confirmar Inscripción! ✨", fontWeight = FontWeight.Bold)
            }

            OutlinedButton(
                onClick = { navController.popBackStack() },
                modifier = Modifier.fillMaxWidth().height(56.dp),
                shape = RoundedCornerShape(24.dp),
                colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Gray)
            ) {
                Text("Tal vez luego 🌸")
            }
        }
    }
}
