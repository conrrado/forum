package com.conrradocamacho.forum.controller

import com.conrradocamacho.forum.model.Topic
import com.conrradocamacho.forum.service.TopicService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/topics")
class TopicController(private val service: TopicService) {

    @GetMapping
    fun list(): List<Topic> {
        return service.list()
    }

    @GetMapping("/{id}")
    fun searchById(@PathVariable id: Long): Topic {
        return service.searchById(id)
    }
}