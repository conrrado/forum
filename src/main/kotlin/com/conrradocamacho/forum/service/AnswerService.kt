package com.conrradocamacho.forum.service

import com.conrradocamacho.forum.dto.AnswerForm
import com.conrradocamacho.forum.dto.AnswerView
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

    fun register(form: AnswerForm) {
        val answer = answerFormMapper.map(form)
        answer.id = answers.size.toLong() + 1
        answers = answers.plus(answer)
    }
}