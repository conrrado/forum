package com.conrradocamacho.forum.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull

data class AnswerForm(
    @field:NotEmpty(message = "message can't be empty")
    val message: String,

    @field:NotNull
    val authorId: Long,

    @field:NotNull
    val topicId: Long
)
