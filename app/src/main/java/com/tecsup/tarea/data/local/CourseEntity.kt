package com.tecsup.tarea.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "courses")
data class CourseEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String,
    val instructor: String,
    val category: String,
    val level: String,
    val duration: String,
    val description: String,
    val isEnrolled: Boolean = false,
    val progress: Float = 0f
)
