package com.conrradocamacho.forum.mapper

import com.conrradocamacho.forum.dto.AnswerForm
import com.conrradocamacho.forum.model.Answer
import com.conrradocamacho.forum.service.TopicService
import com.conrradocamacho.forum.service.UserService
import org.springframework.stereotype.Component

@Component
class AnswerFormMapper(
    private val userService: UserService,
    private val topicService: TopicService
): Mapper<AnswerForm, Answer> {
    override fun map(t: AnswerForm): Answer {
        return Answer(
            message = t.message,
            author = userService.searchById(t.authorId),
            topic = topicService.getTopicById(t.topicId),
            fixed = false
        )
    }
}