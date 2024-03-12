package com.conrradocamacho.forum.model

import java.time.LocalDateTime

data class Answer(
    var id: Long? = null,
    val message: String,
    val createDate: LocalDateTime = LocalDateTime.now(),
    val author: User,
    val topic: Topic,
    val fixed: Boolean
)
