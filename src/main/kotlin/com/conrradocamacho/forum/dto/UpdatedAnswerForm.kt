package com.conrradocamacho.forum.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull

data class UpdatedAnswerForm(
    @field:NotNull
    val id: Long,

    @field:NotEmpty
    val message: String,

    val fixed: Boolean
)
