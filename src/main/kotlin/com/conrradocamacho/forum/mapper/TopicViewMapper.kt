package com.conrradocamacho.forum.mapper

import com.conrradocamacho.forum.dto.TopicView
import com.conrradocamacho.forum.model.Topic
import org.springframework.stereotype.Component

@Component
class TopicViewMapper: Mapper<Topic, TopicView> {
    override fun map(t: Topic): TopicView {
        return TopicView(
            id = t.id,
            title = t.title,
            message = t.message,
            status = t.status,
            createDate = t.createDate
        )
    }
}