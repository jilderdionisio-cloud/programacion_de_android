package com.tecsup.tarea.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.tecsup.tarea.navigation.Screen
import com.tecsup.tarea.viewmodel.CourseViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EnrollmentScreen(navController: NavController, viewModel: CourseViewModel, courseId: Int) {
    val courses by viewModel.catalogState.collectAsState()
    val course = courses.find { it.id == courseId } ?: return

    var dni by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Inscripción al Curso") },
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
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = "Estás inscribiéndote en:",
                style = MaterialTheme.typography.labelLarge
            )
            Text(
                text = course.title,
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.primary
            )

            HorizontalDivider()

            OutlinedTextField(
                value = dni,
                onValueChange = { if (it.length <= 8) dni = it },
                label = { Text("DNI") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Nombre Completo") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = phone,
                onValueChange = { phone = it },
                label = { Text("Teléfono / Celular") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Correo de contacto") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { 
                    viewModel.enroll(courseId)
                    navController.navigate(Screen.MyCourses.route) {
                        popUpTo(Screen.Courses.route) { inclusive = false }
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                enabled = dni.isNotEmpty() && name.isNotEmpty()
            ) {
                Text("Confirmar Inscripción")
            }

            OutlinedButton(
                onClick = { 
                    navController.navigate(Screen.Courses.route) {
                        popUpTo(Screen.Courses.route) { inclusive = true }
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Cancelar")
            }
        }
    }
}
