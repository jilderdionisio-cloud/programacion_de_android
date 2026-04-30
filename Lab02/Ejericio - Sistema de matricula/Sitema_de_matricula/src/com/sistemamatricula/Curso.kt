package com.sistemamatricula

class Curso(
    val codigo: String,
    val nombre: String
) {
    fun mostrarInfo() {
        println("Codigo: $codigo | Nombre: $nombre")
    }

    override fun toString(): String = "$codigo - $nombre"
}
