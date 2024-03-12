package com.conrradocamacho.forum.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size


data class TopicForm(
    @field:NotEmpty(message = "title can't be empty")
    @field:Size(min = 5, max = 100, message = "title must has between 5 and 100 characters")
    val title: String,

    @field:NotEmpty(message = "message can't be empty")
    val message: String,

    @field:NotNull
    val courseId: Long,

    @field:NotNull
    val authorId: Long
)
