package com.tecsup.tarea.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.tecsup.tarea.navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        topBar = {
            LargeTopAppBar(
                title = { Text("Hola, Estudiante 👋") }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = "¿Qué quieres aprender hoy?",
                style = MaterialTheme.typography.titleLarge
            )
            
            HomeButton(
                text = "📚 Cursos",
                icon = Icons.Default.MenuBook,
                onClick = { navController.navigate(Screen.Courses.route) }
            )

            HomeButton(
                text = "🎯 Mis Cursos",
                icon = Icons.Default.Favorite,
                onClick = { navController.navigate(Screen.Profile.route) }
            )

            HomeButton(
                text = "👤 Mi Perfil",
                icon = Icons.Default.Person,
                onClick = { navController.navigate(Screen.Profile.route) }
            )
        }
    }
}

@Composable
fun HomeButton(text: String, icon: ImageVector, onClick: () -> Unit) {
    FilledTonalButton(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp),
        shape = MaterialTheme.shapes.medium
    ) {
        Icon(icon, contentDescription = null)
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = text, style = MaterialTheme.typography.labelLarge)
    }
}
