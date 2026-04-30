package com.tecsup.tarea.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tecsup.tarea.data.local.CourseEntity
import com.tecsup.tarea.data.repository.CourseRepository
import com.tecsup.tarea.models.mockCourses
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class CourseViewModel(private val repository: CourseRepository) : ViewModel() {

    val catalogState: StateFlow<List<CourseEntity>> = repository.allCourses
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val enrolledState: StateFlow<List<CourseEntity>> = repository.enrolledCourses
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    init {
        // Pre-cargar cursos si la DB está vacía
        viewModelScope.launch {
            val entities = mockCourses.map { 
                CourseEntity(
                    title = it.title,
                    instructor = it.instructor,
                    category = it.category,
                    level = it.level,
                    duration = it.duration,
                    description = it.description,
                    progress = it.progress
                )
            }
            repository.insertInitialCourses(entities)
        }
    }

    fun enroll(courseId: Int) {
        viewModelScope.launch {
            repository.enrollInCourse(courseId)
        }
    }
}
