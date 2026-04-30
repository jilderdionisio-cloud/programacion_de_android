package com.tecsup.tarea.navigation

sealed class Screen(val route: String) {
    object Login : Screen("login")
    object Register : Screen("register")
    object Home : Screen("home")
    object Courses : Screen("courses")
    object MyCourses : Screen("my_courses")
    object Profile : Screen("profile")
    object CourseDetail : Screen("course_detail/{courseId}") {
        fun createRoute(courseId: Int) = "course_detail/$courseId"
    }
    object Enrollment : Screen("enrollment/{courseId}") {
        fun createRoute(courseId: Int) = "enrollment/$courseId"
    }
}
