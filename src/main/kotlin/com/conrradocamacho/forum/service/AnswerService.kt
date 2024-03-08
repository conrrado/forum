package com.conrradocamacho.forum.service

import com.conrradocamacho.forum.model.Answer
import com.conrradocamacho.forum.model.Course
import com.conrradocamacho.forum.model.Topic
import com.conrradocamacho.forum.model.User
import org.springframework.stereotype.Service

@Service
class AnswerService(private var answers: List<Answer>) {

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

        val answer = Answer(
            id = 1,
            message = "resposta 1",
            author = User(
                id = 2,
                name = "João",
                email = "joao@email.com"
            ),
            topic = topic,
            fixed = false
        )

        val answer2 = Answer(
            id = 2,
            message = "resposta 2",
            author = User(
                id = 3,
                name = "Luis",
                email = "luis@email.com"
            ),
            topic = topic,
            fixed = false
        )

        answers = listOf(answer, answer2)
    }
    fun listByTopicId(topicId: Long): List<Answer> {
        return answers.stream().filter {
            it.topic.id == topicId
        }.toList()
    }
}