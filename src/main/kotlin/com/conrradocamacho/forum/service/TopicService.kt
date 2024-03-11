package com.conrradocamacho.forum.service

import com.conrradocamacho.forum.dto.TopicForm
import com.conrradocamacho.forum.dto.TopicView
import com.conrradocamacho.forum.model.Topic
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class TopicService(
    private var topics: List<Topic> = listOf(),
    private val courseService: CourseService,
    private val userService: UserService
) {

    fun list(): List<TopicView> {
        return topics.stream().map {
            TopicView(
                id = it.id,
                title = it.title,
                message = it.message,
                status = it.status,
                createDate = it.createDate
            )
        }.collect(Collectors.toList())
    }

    fun searchById(id: Long): TopicView {
        val topic = topics.stream().filter {
            it.id == id
        }.findFirst().get()
        return TopicView(
            id = topic.id,
            title = topic.title,
            message = topic.message,
            status = topic.status,
            createDate = topic.createDate
        )
    }

    fun register(form: TopicForm) {

        topics = topics.plus(
            Topic(
                id = topics.size.toLong() + 1,
                title = form.title,
                message = form.message,
                course = courseService.searchById(form.courseId),
                author = userService.searchById(form.authorId)
            )
        )
    }
}