package com.sistemamatricula

class AlumnoBecado(
    codigo: String,
    nombre: String,
    val porcentajeBeca: Double
) : Alumno(codigo, nombre) {
    private val tarifaBase = 950.0

    override fun calcularMatricula(): Double {
        return tarifaBase * (1 - porcentajeBeca)
    }
}
