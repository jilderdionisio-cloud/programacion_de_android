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
import com.tecsup.tarea.ui.theme.PastelCeleste
import com.tecsup.tarea.ui.theme.PastelPink

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditProfileScreen(navController: NavController) {
    var name by remember { mutableStateOf("Estudiante Estrella ✨") }
    var age by remember { mutableStateOf("20") }
    var institution by remember { mutableStateOf("Tecsup") }
    var bio by remember { mutableStateOf("¡Me encanta aprender cosas nuevas! 💖") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Editar Perfil ✏️", fontWeight = FontWeight.Bold) },
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
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            CuteTextField(value = name, onValueChange = { name = it }, label = "Nombre")
            CuteTextField(value = age, onValueChange = { age = it }, label = "Edad")
            CuteTextField(value = institution, onValueChange = { institution = it }, label = "Institución")
            
            OutlinedTextField(
                value = bio,
                onValueChange = { bio = it },
                label = { Text("Biografía") },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(20.dp),
                minLines = 3,
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = PastelCeleste,
                    focusedBorderColor = PastelPink
                )
            )

            Spacer(modifier = Modifier.height(32.dp))

            Button(
                onClick = { navController.popBackStack() },
                modifier = Modifier.fillMaxWidth().height(56.dp),
                shape = RoundedCornerShape(24.dp),
                colors = ButtonDefaults.buttonColors(containerColor = PastelPink)
            ) {
                Text("Guardar cambios 💾", fontWeight = FontWeight.Bold, color = Color.White)
            }
        }
    }
}
