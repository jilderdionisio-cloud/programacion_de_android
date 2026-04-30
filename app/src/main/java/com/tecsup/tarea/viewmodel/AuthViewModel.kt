package com.tecsup.tarea.viewmodel

import androidx.lifecycle.ViewModel
import com.tecsup.tarea.models.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class AuthViewModel : ViewModel() {
    private val _userState = MutableStateFlow<User?>(null)
    val userState: StateFlow<User?> = _userState

    private val _errorState = MutableStateFlow<String?>(null)
    val errorState: StateFlow<String?> = _errorState

    // Simulación de base de datos en memoria
    private val registeredUsers = mutableListOf<User>(
        User(1, "Usuario Demo", "demo@tecsup.edu.pe", "123456")
    )

    fun login(email: String, password: String, onSuccess: () -> Unit) {
        val user = registeredUsers.find { it.email == email && it.password == password }
        if (user != null) {
            _userState.value = user
            _errorState.value = null
            onSuccess()
        } else {
            _errorState.value = "Credenciales incorrectas"
        }
    }

    fun register(name: String, email: String, pass: String, onSuccess: () -> Unit) {
        val existingUser = registeredUsers.find { it.email == email }
        if (existingUser == null) {
            val newUser = User(id = registeredUsers.size + 1, name = name, email = email, password = pass)
            registeredUsers.add(newUser)
            _userState.value = newUser
            _errorState.value = null
            onSuccess()
        } else {
            _errorState.value = "El correo ya está registrado"
        }
    }

    fun logout() {
        _userState.value = null
    }
}
