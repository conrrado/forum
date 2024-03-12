package com.conrradocamacho.forum.mapper

import com.conrradocamacho.forum.dto.AnswerView
import com.conrradocamacho.forum.model.Answer
import org.springframework.stereotype.Component

@Component
class AnswerViewMapper: Mapper<Answer, AnswerView> {
    override fun map(t: Answer): AnswerView {
        return AnswerView(
            id = t.id,
            message = t.message,
            createDate = t.createDate,
            fixed = t.fixed
        )
    }
}