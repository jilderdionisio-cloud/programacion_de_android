package com.tecsup.tarea.data.local

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface CourseDao {
    @Query("SELECT * FROM courses")
    fun getAllCourses(): Flow<List<CourseEntity>>

    @Query("SELECT * FROM courses WHERE isEnrolled = 1")
    fun getEnrolledCourses(): Flow<List<CourseEntity>>

    @Query("SELECT * FROM courses WHERE id = :id")
    suspend fun getCourseById(id: Int): CourseEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(courses: List<CourseEntity>)

    @Query("UPDATE courses SET isEnrolled = 1 WHERE id = :courseId")
    suspend fun enrollInCourse(courseId: Int)

    @Query("SELECT COUNT(*) FROM courses")
    suspend fun getCount(): Int
}
