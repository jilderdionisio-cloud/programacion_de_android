package com.sistemamatricula

class AlumnoRegular(
    codigo: String,
    nombre: String,
    val creditosInscritos: Int
) : Alumno(codigo, nombre) {
    private val costoPorCredito = 85.0

    override fun calcularMatricula(): Double {
        return creditosInscritos * costoPorCredito
    }
}
