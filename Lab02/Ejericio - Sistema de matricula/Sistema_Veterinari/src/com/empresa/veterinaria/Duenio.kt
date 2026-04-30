package com.empresa.veterinaria

class Duenio(
    private val nombre: String,
    private val telefono: String
) {
    private val mascotas = mutableListOf<Mascota>()

    fun registrarMascota(mascota: Mascota) {
        mascotas.add(mascota)
        println("Mascota ${mascota.obtenerNombre()} registrada para $nombre.")
    }

    fun listarMascotas() {
        println("==============================")
        println("Dueno: $nombre")
        println("Telefono: $telefono")
        println("Mascotas registradas: ${mascotas.size}")
        println("==============================")

        for (mascota in mascotas) {
            mascota.mostrarFicha()
        }
    }
}
