package com.conrradocamacho.forum.dto

import java.time.LocalDateTime

data class AnswerView(
    val id: Long?,
    val message: String,
    val createDate: LocalDateTime,
    val fixed: Boolean
)
