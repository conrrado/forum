package com.conrradocamacho.forum.service

import com.conrradocamacho.forum.dto.TopicForm
import com.conrradocamacho.forum.dto.TopicView
import com.conrradocamacho.forum.mapper.TopicFormMapper
import com.conrradocamacho.forum.mapper.TopicViewMapper
import com.conrradocamacho.forum.model.Topic
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class TopicService(
    private var topics: List<Topic> = listOf(),
    private val topicViewMapper: TopicViewMapper,
    private val topicFormMapper: TopicFormMapper
) {

    fun list(): List<TopicView> {
        return topics.stream().map {
            topicViewMapper.map(it)
        }.collect(Collectors.toList())
    }

    fun searchById(id: Long): TopicView {
        val topic = topics.stream().filter {
            it.id == id
        }.findFirst().get()
        return topicViewMapper.map(topic)
    }

    fun getTopicById(id: Long): Topic {
        return topics.stream().filter { it.id == id }.findFirst().get()
    }

    fun register(form: TopicForm) {
        val topic = topicFormMapper.map(form)
        topic.id = topics.size.toLong() + 1
        topics = topics.plus(topic)
    }
}