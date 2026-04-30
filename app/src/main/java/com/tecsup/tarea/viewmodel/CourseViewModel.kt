package com.tecsup.tarea.viewmodel

import androidx.lifecycle.ViewModel
import com.tecsup.tarea.models.Course
import com.tecsup.tarea.models.mockCourses
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class CourseViewModel : ViewModel() {

    private val _catalogState = MutableStateFlow<List<Course>>(mockCourses)
    val catalogState: StateFlow<List<Course>> = _catalogState

    private val _enrolledIds = MutableStateFlow<Set<Int>>(emptySet())
    
    private val _enrolledState = MutableStateFlow<List<Course>>(emptyList())
    val enrolledState: StateFlow<List<Course>> = _enrolledState

    fun enroll(courseId: Int) {
        val currentEnrolled = _enrolledIds.value
        if (!currentEnrolled.contains(courseId)) {
            val newEnrolledIds = currentEnrolled + courseId
            _enrolledIds.value = newEnrolledIds
            updateLists(newEnrolledIds)
        }
    }

    private fun updateLists(enrolledIds: Set<Int>) {
        _catalogState.value = mockCourses.map { 
            it.copy(isEnrolled = enrolledIds.contains(it.id))
        }
        _enrolledState.value = _catalogState.value.filter { it.isEnrolled }
    }
    
    fun getCourseById(id: Int): Course? {
        return _catalogState.value.find { it.id == id }
    }
}
