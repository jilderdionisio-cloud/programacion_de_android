package com.tecsup.tarea

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.tecsup.tarea.navigation.AppNavigation
import com.tecsup.tarea.ui.theme.TareaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            TareaTheme {
                AppNavigation()
            }
        }
    }
}