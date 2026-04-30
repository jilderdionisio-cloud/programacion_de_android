package com.empresa.veterinaria

class Perro(
    nombre: String,
    edad: Int,
    peso: Double,
    private val raza: String
) : Mascota(nombre, edad, peso) {

    override fun emitirSonido(): String = "Guau"

    override fun diagnosticar(): String = "El perro ${obtenerNombre()} esta estable y requiere control general."

    override fun calcularCostoConsulta(): Double = 80.0 + (obtenerPeso() * 2.5)

    override fun mostrarFicha() {
        println("----- Ficha de Perro -----")
        mostrarDatos()
        println("Raza: $raza")
        println("Sonido: ${emitirSonido()}")
        println("Diagnostico: ${diagnosticar()}")
        println("Costo consulta: S/. ${"%.2f".format(calcularCostoConsulta())}")
        println()
    }
}
