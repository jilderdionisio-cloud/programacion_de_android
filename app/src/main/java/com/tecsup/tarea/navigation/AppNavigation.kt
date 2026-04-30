package com.tecsup.tarea.navigation

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.navArgument
import com.tecsup.tarea.screens.*
import com.tecsup.tarea.viewmodel.AuthViewModel
import com.tecsup.tarea.viewmodel.CourseViewModel

@Composable
fun AppNavigation(authViewModel: AuthViewModel, courseViewModel: CourseViewModel) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Login.route,
        enterTransition = { 
            scaleIn(animationSpec = tween(500)) + fadeIn(animationSpec = tween(500)) 
        },
        exitTransition = { 
            scaleOut(animationSpec = tween(500)) + fadeOut(animationSpec = tween(500)) 
        },
        popEnterTransition = {
            scaleIn(animationSpec = tween(500)) + fadeIn(animationSpec = tween(500))
        },
        popExitTransition = {
            scaleOut(animationSpec = tween(500)) + fadeOut(animationSpec = tween(500))
        }
    ) {
        composable(Screen.Login.route) { LoginScreen(navController, authViewModel) }
        composable(Screen.Register.route) { RegisterScreen(navController, authViewModel) }
        composable(Screen.Home.route) { HomeScreen(navController) }
        composable(Screen.Courses.route) { CoursesScreen(navController, courseViewModel) }
        composable(Screen.MyCourses.route) { MyCoursesScreen(navController, courseViewModel) }
        composable(Screen.Profile.route) { ProfileScreen(navController, authViewModel) }
        composable(Screen.ProfileEdit.route) { EditProfileScreen(navController, authViewModel) }

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
