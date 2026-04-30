package com.sistemamatricula

abstract class Alumno(
    val codigo: String,
    val nombre: String
) {
    val cursos = mutableListOf<Curso>()

    abstract fun calcularMatricula(): Double

    fun inscribirCurso(curso: Curso) {
        if (cursos.size < MAXIMO_CURSOS) {
            cursos.add(curso)
        } else {
            println("Error: el alumno $nombre no puede inscribir mas de $MAXIMO_CURSOS cursos.")
        }
    }

    fun mostrarResumen() {
        println("Codigo: $codigo")
        println("Nombre: $nombre")
        println("Cursos inscritos:")

        if (cursos.isEmpty()) {
            println("- Ninguno")
        } else {
            cursos.forEach { println("- $it") }
        }

        println("Costo total de matricula: S/. ${"%.2f".format(calcularMatricula())}")
        println()
    }

    companion object {
        const val MAXIMO_CURSOS = 6
    }
}
