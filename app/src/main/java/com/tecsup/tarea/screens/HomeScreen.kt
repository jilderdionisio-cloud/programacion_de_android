package com.tecsup.tarea.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.tecsup.tarea.navigation.Screen
import com.tecsup.tarea.ui.theme.PastelCeleste
import com.tecsup.tarea.ui.theme.PastelLila
import com.tecsup.tarea.ui.theme.PastelPink

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        topBar = {
            LargeTopAppBar(
                title = { 
                    Column {
                        Text("¡Hola, Estudiante! 👋", fontWeight = FontWeight.ExtraBold, color = PastelPink)
                        Text("¿Qué aventura elegiremos hoy? ✨", style = MaterialTheme.typography.bodyMedium, color = Color.Gray)
                    }
                },
                colors = TopAppBarDefaults.largeTopAppBarColors(containerColor = Color.Transparent)
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            CuteHomeButton(
                text = "📚 Explorar Cursos",
                icon = Icons.Default.MenuBook,
                description = "✨ Encuentra algo nuevo",
                color = PastelCeleste,
                onClick = { navController.navigate(Screen.Courses.route) }
            )

            CuteHomeButton(
                text = "🎯 Mis Cursos",
                icon = Icons.Default.Favorite,
                description = "💖 Sigue tu progreso",
                color = PastelPink,
                onClick = { navController.navigate(Screen.MyCourses.route) }
            )

            CuteHomeButton(
                text = "👤 Mi Perfil",
                icon = Icons.Default.Person,
                description = "🌈 Gestiona tu cuenta",
                color = PastelLila,
                onClick = { navController.navigate(Screen.Profile.route) }
            )
        }
    }
}

@Composable
fun CuteHomeButton(text: String, icon: ImageVector, description: String, color: Color, onClick: () -> Unit) {
    ElevatedCard(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth().height(110.dp),
        shape = RoundedCornerShape(28.dp),
        colors = CardDefaults.elevatedCardColors(containerColor = Color.White)
    ) {
        Row(
            modifier = Modifier.fillMaxSize().padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                modifier = Modifier.size(64.dp),
                shape = RoundedCornerShape(20.dp),
                color = color.copy(alpha = 0.2f)
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Icon(icon, null, tint = color, modifier = Modifier.size(32.dp))
                }
            }
            Spacer(modifier = Modifier.width(20.dp))
            Column {
                Text(text = text, style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.ExtraBold))
                Text(text = description, style = MaterialTheme.typography.bodySmall, color = Color.Gray)
            }
        }
    }
}
