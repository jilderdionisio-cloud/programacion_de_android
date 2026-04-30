package com.tecsup.tarea.navigation

sealed class Screen(val route: String) {
    object Login : Screen("login")
    object Home : Screen("home")
    object Courses : Screen("courses")
    object Profile : Screen("profile")
    object CourseDetail : Screen("course_detail/{courseId}") {
        fun createRoute(courseId: Int) = "course_detail/$courseId"
    }
}
