package com.conrradocamacho.forum.controller

import com.conrradocamacho.forum.dto.TopicForm
import com.conrradocamacho.forum.dto.TopicView
import com.conrradocamacho.forum.dto.UpdatedTopicForm
import com.conrradocamacho.forum.service.TopicService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/topics")
class TopicController(private val service: TopicService) {

    @GetMapping
    fun list(): List<TopicView> {
        return service.list()
    }

    @GetMapping("/{id}")
    fun searchById(@PathVariable id: Long): TopicView {
        return service.searchById(id)
    }

    @PostMapping
    fun register(@RequestBody @Valid form: TopicForm) {
        service.register(form)
    }

    @PutMapping
    fun update(@RequestBody @Valid form: UpdatedTopicForm) {
        service.update(form)
    }

    @DeleteMapping("/{id}")
    fun remove(@PathVariable id: Long) {
        service.remove(id)
    }
}