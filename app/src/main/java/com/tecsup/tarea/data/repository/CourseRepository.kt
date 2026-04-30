package com.tecsup.tarea.data.repository

import com.tecsup.tarea.data.local.CourseDao
import com.tecsup.tarea.data.local.CourseEntity
import kotlinx.coroutines.flow.Flow

class CourseRepository(private val courseDao: CourseDao) {
    val allCourses: Flow<List<CourseEntity>> = courseDao.getAllCourses()
    val enrolledCourses: Flow<List<CourseEntity>> = courseDao.getEnrolledCourses()

    suspend fun enrollInCourse(id: Int) = courseDao.enrollInCourse(id)
    suspend fun getCourseById(id: Int) = courseDao.getCourseById(id)
    
    suspend fun insertInitialCourses(courses: List<CourseEntity>) {
        if (courseDao.getCount() == 0) {
            courseDao.insertAll(courses)
        }
    }
}
