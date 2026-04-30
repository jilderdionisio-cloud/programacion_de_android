package com.empresa.veterinaria

class Gato(
    nombre: String,
    edad: Int,
    peso: Double,
    private val esIndoor: Boolean
) : Mascota(nombre, edad, peso) {

    override fun emitirSonido(): String = "Miau"

    override fun diagnosticar(): String {
        val tipoDeVida = if (esIndoor) "de interior" else "con acceso al exterior"
        return "El gato ${obtenerNombre()} es $tipoDeVida y necesita evaluacion felina preventiva."
    }

    override fun calcularCostoConsulta(): Double = 65.0 + (obtenerPeso() * 2.0)

    override fun mostrarFicha() {
        println("----- Ficha de Gato -----")
        mostrarDatos()
        println("Es indoor: ${if (esIndoor) "Si" else "No"}")
        println("Sonido: ${emitirSonido()}")
        println("Diagnostico: ${diagnosticar()}")
        println("Costo consulta: S/. ${"%.2f".format(calcularCostoConsulta())}")
        println()
    }
}
