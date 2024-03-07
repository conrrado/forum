package com.conrradocamacho.forum.model

import java.time.LocalDateTime

data class Answer(
    val id: Long? = null,
    val message: String,
    val createDate: LocalDateTime = LocalDateTime.now(),
    val author: User,
    val topic: Topic,
    val fixed: Boolean
)
