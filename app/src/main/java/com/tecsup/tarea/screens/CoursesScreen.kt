package com.tecsup.tarea.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.tecsup.tarea.models.mockCourses
import com.tecsup.tarea.navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CoursesScreen(navController: NavController) {
    var selectedCategory by remember { mutableStateOf("Todos") }
    val categories = listOf("Todos", "Programación 💻", "Diseño 🎨", "Negocios 📈")
    
    val filteredCourses = if (selectedCategory == "Todos") {
        mockCourses
    } else {
        mockCourses.filter { selectedCategory.contains(it.category) }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Explorar Cursos") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Atrás")
                    }
                }
            )
        }
    ) { padding ->
        Column(modifier = Modifier.padding(padding)) {
            // Filtros
            LazyRow(
                modifier = Modifier.padding(8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(categories) { category ->
                    FilterChip(
                        selected = selectedCategory == category,
                        onClick = { selectedCategory = category },
                        label = { Text(category) }
                    )
                }
            }

            // Lista de cursos
            LazyColumn(
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(filteredCourses) { course ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { 
                                navController.navigate(Screen.CourseDetail.createRoute(course.id))
                            }
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            // Simulamos una imagen con un box de color
                            Surface(
                                modifier = Modifier.fillMaxWidth().height(150.dp),
                                color = MaterialTheme.colorScheme.primaryContainer,
                                shape = MaterialTheme.shapes.medium
                            ) { }
                            Spacer(modifier = Modifier.height(12.dp))
                            Text(text = course.title, style = MaterialTheme.typography.titleMedium)
                            Text(text = "Instructor: ${course.instructor}", style = MaterialTheme.typography.bodySmall)
                            Spacer(modifier = Modifier.height(8.dp))
                            SuggestionChip(
                                onClick = { },
                                label = { Text(course.level) }
                            )
                        }
                    }
                }
            }
        }
    }
}
