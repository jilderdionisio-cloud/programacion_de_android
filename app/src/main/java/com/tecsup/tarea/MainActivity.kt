package com.tecsup.tarea

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.tecsup.tarea.navigation.AppNavigation
import com.tecsup.tarea.ui.theme.TareaTheme
import com.tecsup.tarea.viewmodel.AuthViewModel
import com.tecsup.tarea.viewmodel.CourseViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            TareaTheme {
                val authViewModel: AuthViewModel = viewModel()
                val courseViewModel: CourseViewModel = viewModel()
                
                AppNavigation(authViewModel, courseViewModel)
            }
        }
    }
}
