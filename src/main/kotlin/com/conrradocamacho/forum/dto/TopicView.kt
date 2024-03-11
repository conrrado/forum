package com.conrradocamacho.forum.dto

import com.conrradocamacho.forum.model.StatusTopic
import java.time.LocalDateTime

data class TopicView(
    val id: Long?,
    val title: String,
    val message: String,
    val status: StatusTopic,
    val createDate: LocalDateTime
)
