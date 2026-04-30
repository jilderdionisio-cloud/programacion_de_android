package com.empresa.veterinaria

abstract class Mascota(
    private val nombre: String,
    private val edad: Int,
    private val peso: Double
) : Tratable {

    fun obtenerNombre(): String = nombre

    fun obtenerEdad(): Int = edad

    fun obtenerPeso(): Double = peso

    abstract fun emitirSonido(): String

    fun mostrarDatos() {
        println("Nombre: $nombre")
        println("Edad: $edad anios")
        println("Peso: $peso kg")
    }
}
