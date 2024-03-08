package com.conrradocamacho.forum.controller

import com.conrradocamacho.forum.model.Answer
import com.conrradocamacho.forum.service.AnswerService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/answers")
class AnswerController(private val service: AnswerService) {

    @GetMapping("/topic/{topicId}")
    fun listByTopicId(@PathVariable topicId: Long): List<Answer> {
        return service.listByTopicId(topicId)
    }
}