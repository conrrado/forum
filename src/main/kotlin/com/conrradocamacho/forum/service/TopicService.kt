package com.conrradocamacho.forum.service

import com.conrradocamacho.forum.dto.TopicForm
import com.conrradocamacho.forum.dto.TopicView
import com.conrradocamacho.forum.dto.UpdatedTopicForm
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

    fun register(form: TopicForm): TopicView {
        val topic = topicFormMapper.map(form)
        topic.id = topics.size.toLong() + 1
        topics = topics.plus(topic)
        return topicViewMapper.map(topic)
    }

    fun update(form: UpdatedTopicForm): TopicView {
        val topic = topics.stream().filter {
            it.id == form.id
        }.findFirst().get()
        val updatedTopic = Topic(
            id = form.id,
            title = form.title,
            message = form.message,
            course = topic.course,
            author = topic.author,
            answers = topic.answers,
            status = topic.status,
            createDate = topic.createDate
        )
        topics = topics.minus(topic).plus(updatedTopic)
        return topicViewMapper.map(updatedTopic)
    }

    fun remove(id: Long) {
        val topic = topics.stream().filter {
            it.id == id
        }.findFirst().get()
        topics = topics.minus(topic)
    }
}