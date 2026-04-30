package com.tecsup.tarea.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.tecsup.tarea.models.Course
import com.tecsup.tarea.navigation.Screen
import com.tecsup.tarea.ui.theme.PastelPink
import com.tecsup.tarea.ui.theme.PastelLila
import com.tecsup.tarea.ui.theme.PastelCeleste
import com.tecsup.tarea.ui.theme.DeepPurple
import com.tecsup.tarea.viewmodel.CourseViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CoursesScreen(navController: NavController, viewModel: CourseViewModel) {
    var selectedCategory by remember { mutableStateOf("Todos") }
    val categories = listOf("Todos", "Programación 💻", "Diseño 🎨", "Negocios 📈")
    val courses by viewModel.catalogState.collectAsState()
    val filteredCourses = if (selectedCategory == "Todos") courses else courses.filter { selectedCategory.contains(it.category) }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Catálogo Mágico ✨", fontWeight = FontWeight.ExtraBold) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, "Atrás", tint = PastelPink)
                    }
                }
            )
        }
    ) { padding ->
        Column(modifier = Modifier.padding(padding)) {
            LazyRow(
                modifier = Modifier.padding(16.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(categories) { category ->
                    FilterChip(
                        selected = selectedCategory == category,
                        onClick = { selectedCategory = category },
                        label = { Text(category) },
                        shape = CircleShape,
                        colors = FilterChipDefaults.filterChipColors(
                            selectedContainerColor = PastelLila,
                            selectedLabelColor = Color.White
                        )
                    )
                }
            }

            LazyColumn(
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                items(filteredCourses) { course ->
                    CuteCourseCard(course) {
                        navController.navigate(Screen.CourseDetail.createRoute(course.id))
                    }
                }
            }
        }
    }
}

@Composable
fun CuteCourseCard(course: Course, onClick: () -> Unit) {
    ElevatedCard(
        modifier = Modifier.fillMaxWidth().clickable(onClick = onClick),
        shape = RoundedCornerShape(32.dp),
        colors = CardDefaults.elevatedCardColors(containerColor = Color.White)
    ) {
        Column {
            Box(modifier = Modifier.fillMaxWidth().height(140.dp).background(
                brush = Brush.linearGradient(colors = listOf(PastelCeleste, PastelLila))
            )) {
                Row(modifier = Modifier.padding(12.dp), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    val badgeColor = if (course.id % 2 == 0) PastelPink else PastelCeleste
                    CuteBadge(text = if (course.id % 2 == 0) "✨ Nuevo" else "💖 Recomendado", color = badgeColor)
                }
            }
            Column(modifier = Modifier.padding(20.dp)) {
                Text(text = course.title, style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.ExtraBold)
                Text(text = "👩‍🏫 ${course.instructor}", style = MaterialTheme.typography.bodyMedium, color = Color.Gray)
                Spacer(modifier = Modifier.height(12.dp))
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    CuteBadge(text = course.level, color = PastelLila.copy(alpha = 0.3f), textColor = DeepPurple)
                    Text(text = "⏱ ${course.duration}", style = MaterialTheme.typography.labelMedium)
                }
            }
        }
    }
}

@Composable
fun CuteBadge(text: String, color: Color, textColor: Color = Color.White) {
    Surface(color = color, shape = CircleShape) {
        Text(text = text, modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp), style = MaterialTheme.typography.labelSmall, color = textColor, fontWeight = FontWeight.Bold)
    }
}
