package com.tecsup.tarea

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.tecsup.tarea.data.local.AppDatabase
import com.tecsup.tarea.data.repository.CourseRepository
import com.tecsup.tarea.navigation.AppNavigation
import com.tecsup.tarea.ui.theme.TareaTheme
import com.tecsup.tarea.viewmodel.CourseViewModel
import com.tecsup.tarea.viewmodel.CourseViewModelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inicialización de DB y Repositorio
        val database = AppDatabase.getDatabase(this)
        val repository = CourseRepository(database.courseDao())

        setContent {
            TareaTheme {
                // Instanciamos el ViewModel usando un Factory sencillo
                val courseViewModel: CourseViewModel = viewModel(
                    factory = CourseViewModelFactory(repository)
                )
                
                AppNavigation(courseViewModel)
            }
        }
    }
}
