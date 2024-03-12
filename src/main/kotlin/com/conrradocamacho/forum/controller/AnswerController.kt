package com.conrradocamacho.forum.controller

import com.conrradocamacho.forum.dto.AnswerForm
import com.conrradocamacho.forum.dto.AnswerView
import com.conrradocamacho.forum.service.AnswerService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/answers")
class AnswerController(private val service: AnswerService) {

    @GetMapping("/topic/{topicId}")
    fun listByTopicId(@PathVariable topicId: Long): List<AnswerView> {
        return service.listByTopicId(topicId)
    }

    @PostMapping
    fun register(@RequestBody @Valid form: AnswerForm) {
        service.register(form)
    }
}