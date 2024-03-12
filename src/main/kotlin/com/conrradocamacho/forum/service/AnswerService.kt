package com.conrradocamacho.forum.service

import com.conrradocamacho.forum.dto.AnswerForm
import com.conrradocamacho.forum.dto.AnswerView
import com.conrradocamacho.forum.dto.UpdatedAnswerForm
import com.conrradocamacho.forum.mapper.AnswerFormMapper
import com.conrradocamacho.forum.mapper.AnswerViewMapper
import com.conrradocamacho.forum.model.Answer
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class AnswerService(
    private var answers: List<Answer>,
    private val answerFormMapper: AnswerFormMapper,
    private val answerViewMapper: AnswerViewMapper
) {

    fun listByTopicId(topicId: Long): List<AnswerView> {
        return answers.stream().filter {
            it.topic.id == topicId
        }.map {
            answerViewMapper.map(it)
        }.collect(Collectors.toList())
    }

    fun register(form: AnswerForm): AnswerView {
        val answer = answerFormMapper.map(form)
        answer.id = answers.size.toLong() + 1
        answers = answers.plus(answer)
        return answerViewMapper.map(answer)
    }

    fun update(form: UpdatedAnswerForm): AnswerView? {
        val answer = getAnswerById(form.id)
        val updatedAnswer = Answer(
            id = form.id,
            message = form.message,
            author = answer.author,
            topic = answer.topic,
            fixed = form.fixed,
            createDate = answer.createDate
        )
        answers = answers.minus(answer).plus(updatedAnswer)
        return answerViewMapper.map(updatedAnswer)
    }

    fun remove(id: Long) {
        val answer = getAnswerById(id)
        answers = answers.minus(answer)
    }

    private fun getAnswerById(id: Long): Answer {
        return answers.stream().filter {
            it.id == id
        }.findFirst().get()
    }
}