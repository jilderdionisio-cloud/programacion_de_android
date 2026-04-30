package com.empresa.veterinaria

fun main() {
    val duenio1 = Duenio("Carla Mendoza", "987654321")
    val duenio2 = Duenio("Luis Ramirez", "912345678")

    val perro1 = Perro("Firulais", 4, 18.5, "Labrador")
    val gato1 = Gato("Mishi", 2, 4.2, true)
    val perro2 = Perro("Rocky", 6, 22.0, "Pastor Aleman")
    val gato2 = Gato("Nina", 3, 3.8, false)

    duenio1.registrarMascota(perro1)
    duenio1.registrarMascota(gato1)
    duenio2.registrarMascota(perro2)
    duenio2.registrarMascota(gato2)

    println()
    duenio1.listarMascotas()
    duenio2.listarMascotas()
}
