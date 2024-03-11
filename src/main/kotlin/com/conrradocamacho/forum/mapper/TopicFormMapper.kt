package com.conrradocamacho.forum.mapper

import com.conrradocamacho.forum.dto.TopicForm
import com.conrradocamacho.forum.model.Topic
import com.conrradocamacho.forum.service.CourseService
import com.conrradocamacho.forum.service.UserService
import org.springframework.stereotype.Component

@Component
class TopicFormMapper(
    private val courseService: CourseService,
    private val userService: UserService
): Mapper<TopicForm, Topic> {
    override fun map(t: TopicForm): Topic {
        return Topic(
            title = t.title,
            message = t.message,
            course = courseService.searchById(t.courseId),
            author = userService.searchById(t.authorId)
        )
    }

}
