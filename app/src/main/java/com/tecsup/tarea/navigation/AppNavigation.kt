package com.tecsup.tarea.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.navArgument
import com.tecsup.tarea.screens.*
import com.tecsup.tarea.viewmodel.CourseViewModel

@Composable
fun AppNavigation(courseViewModel: CourseViewModel) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Login.route
    ) {
        composable(Screen.Login.route) {
            LoginScreen(navController)
        }

        composable(Screen.Register.route) {
            RegisterScreen(navController)
        }

        composable(Screen.Home.route) {
            HomeScreen(navController)
        }

        composable(Screen.Courses.route) {
            CoursesScreen(navController, courseViewModel)
        }

        composable(Screen.MyCourses.route) {
            MyCoursesScreen(navController, courseViewModel)
        }

        composable(Screen.Profile.route) {
            ProfileScreen(navController)
        }

        composable(
            route = Screen.CourseDetail.route,
            arguments = listOf(navArgument("courseId") { type = NavType.IntType })
        ) { backStackEntry ->
            val courseId = backStackEntry.arguments?.getInt("courseId") ?: 0
            CourseDetailScreen(navController, courseViewModel, courseId)
        }

        composable(
            route = Screen.Enrollment.route,
            arguments = listOf(navArgument("courseId") { type = NavType.IntType })
        ) { backStackEntry ->
            val courseId = backStackEntry.arguments?.getInt("courseId") ?: 0
            EnrollmentScreen(navController, courseViewModel, courseId)
        }
    }
}
