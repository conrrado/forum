package com.conrradocamacho.forum.service

import com.conrradocamacho.forum.model.Course
import com.conrradocamacho.forum.model.Topic
import com.conrradocamacho.forum.model.User
import org.springframework.stereotype.Service
import java.util.*

@Service
class TopicService {
    fun list(): List<Topic> {
        val topic = Topic(
            id = 1,
            title = "Duvida Kotlin",
            message = "Variaveis no Kotlin",
            course = Course(
                id = 1,
                name = "Kotlin",
                category = "Programação"
            ),
            author = User(
                id = 1,
                name = "Ana da Silva",
                email = "ana@email.com"
            )
        )

        return Arrays.asList(topic, topic, topic)
    }
}