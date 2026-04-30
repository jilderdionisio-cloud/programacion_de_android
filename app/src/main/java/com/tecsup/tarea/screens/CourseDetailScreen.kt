package com.tecsup.tarea.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.tecsup.tarea.models.mockCourses

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CourseDetailScreen(navController: NavController, courseId: Int) {
    val course = mockCourses.find { it.id == courseId } ?: return

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Detalle del Curso") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Atrás")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {
            Surface(
                modifier = Modifier.fillMaxWidth().height(250.dp),
                color = MaterialTheme.colorScheme.secondaryContainer,
                shape = MaterialTheme.shapes.large
            ) { }
            
            Spacer(modifier = Modifier.height(24.dp))
            
            Text(text = course.title, style = MaterialTheme.typography.headlineMedium)
            Text(text = "Por ${course.instructor}", style = MaterialTheme.typography.titleSmall, color = MaterialTheme.colorScheme.secondary)
            
            Spacer(modifier = Modifier.height(16.dp))
            
            ListItem(
                headlineContent = { Text("Duración") },
                supportingContent = { Text(course.duration) }
            )
            
            ListItem(
                headlineContent = { Text("Nivel") },
                supportingContent = { Text(course.level) }
            )

            Spacer(modifier = Modifier.height(16.dp))
            
            Text(text = "Descripción", style = MaterialTheme.typography.titleLarge)
            Text(
                text = course.description,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(vertical = 8.dp)
            )
            
            Spacer(modifier = Modifier.height(32.dp))
            
            Button(
                onClick = { /* Lógica de inscripción */ },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Inscribirse ahora")
            }
        }
    }
}
