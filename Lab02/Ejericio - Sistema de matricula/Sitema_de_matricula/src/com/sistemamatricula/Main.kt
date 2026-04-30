package com.sistemamatricula

fun main() {
    val curso1 = Curso("C101", "Matematica")
    val curso2 = Curso("C102", "Programacion")
    val curso3 = Curso("C103", "Base de Datos")
    val curso4 = Curso("C104", "Redes")
    val curso5 = Curso("C105", "Ingles")
    val curso6 = Curso("C106", "Fisica")
    val curso7 = Curso("C107", "Estadistica")

    val alumnos: List<Alumno> = listOf(
        AlumnoRegular("A001", "Juan Perez", 18),
        AlumnoRegular("A002", "Maria Lopez", 20),
        AlumnoBecado("A003", "Carlos Ruiz", 0.25),
        AlumnoBecado("A004", "Ana Torres", 0.40)
    )

    alumnos[0].inscribirCurso(curso1)
    alumnos[0].inscribirCurso(curso2)
    alumnos[0].inscribirCurso(curso3)

    alumnos[1].inscribirCurso(curso1)
    alumnos[1].inscribirCurso(curso2)
    alumnos[1].inscribirCurso(curso3)
    alumnos[1].inscribirCurso(curso4)
    alumnos[1].inscribirCurso(curso5)
    alumnos[1].inscribirCurso(curso6)
    alumnos[1].inscribirCurso(curso7)

    alumnos[2].inscribirCurso(curso2)
    alumnos[2].inscribirCurso(curso4)

    alumnos[3].inscribirCurso(curso1)
    alumnos[3].inscribirCurso(curso5)

    alumnos.forEach { it.mostrarResumen() }
}
