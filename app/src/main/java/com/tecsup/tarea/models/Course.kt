package com.tecsup.tarea.models

data class Course(
    val id: Int,
    val title: String,
    val instructor: String,
    val category: String,
    val level: String,
    val duration: String,
    val description: String,
    val progress: Float = 0f,
    val isEnrolled: Boolean = false
)

val mockCourses = listOf(
    Course(1, "Kotlin desde Cero", "Juan León", "Programación", "Básico", "8 horas", "Aprende Kotlin para crear apps Android.", 0.75f),
    Course(2, "Jetpack Compose", "Ana Torres", "Programación", "Intermedio", "10 horas", "Diseña interfaces modernas con Compose.", 0.40f),
    Course(3, "Diseño UI/UX", "Luis Ramos", "Diseño", "Básico", "6 horas", "Principios de diseño visual y experiencia de usuario.", 0.20f),
    Course(4, "Branding Digital", "María García", "Diseño", "Intermedio", "5 horas", "Crea marcas modernas para entornos digitales."),
    Course(5, "Marketing para Startups", "Carlos Pérez", "Negocios", "Básico", "7 horas", "Estrategias para crecer negocios digitales."),
    Course(6, "Gestión de Proyectos", "Lucía Díaz", "Negocios", "Avanzado", "12 horas", "Administra proyectos tecnológicos de forma profesional.")
)
