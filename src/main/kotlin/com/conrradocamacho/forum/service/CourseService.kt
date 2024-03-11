package com.conrradocamacho.forum.service

import com.conrradocamacho.forum.model.Course
import org.springframework.stereotype.Service

@Service
class CourseService(final var courses: List<Course>) {

    init {
        val course = Course(
            id = 1,
            name = "Kotlin",
            category = "Programação"
        )

        courses = listOf(course)
    }

    fun searchById(id: Long): Course {
        return courses.stream().filter { it.id == id }.findFirst().get()
    }

}
