package com.conrradocamacho.forum.service

import com.conrradocamacho.forum.model.Course
import com.conrradocamacho.forum.model.Topic
import com.conrradocamacho.forum.model.User
import org.springframework.stereotype.Service

@Service
class TopicService(private var topics: List<Topic>) {

    init {
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

        val topic2 = Topic(
            id = 2,
            title = "Duvida Kotlin 2",
            message = "Variaveis no Kotlin 2",
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

        val topic3 = Topic(
            id = 3,
            title = "Duvida Kotlin 3",
            message = "Variaveis no Kotlin 3",
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

        topics = listOf(topic, topic2, topic3)
    }
    fun list(): List<Topic> {
        return topics
    }

    fun searchById(id: Long): Topic {
        return topics.stream().filter {
            it.id == id
        }.findFirst().get()
    }
}