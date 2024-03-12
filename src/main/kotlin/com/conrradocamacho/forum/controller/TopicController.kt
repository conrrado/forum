package com.conrradocamacho.forum.controller

import com.conrradocamacho.forum.dto.TopicForm
import com.conrradocamacho.forum.dto.TopicView
import com.conrradocamacho.forum.dto.UpdatedTopicForm
import com.conrradocamacho.forum.service.TopicService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

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
    fun register(
        @RequestBody @Valid form: TopicForm,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<TopicView> {
        val topicView = service.register(form)
        val uri = uriBuilder.path("/topics/${topicView.id}").build().toUri()
        return ResponseEntity.created(uri).body(topicView)
    }

    @PutMapping
    fun update(@RequestBody @Valid form: UpdatedTopicForm): ResponseEntity<TopicView> {
        val topicView = service.update(form)
        return ResponseEntity.ok(topicView)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun remove(@PathVariable id: Long) {
        service.remove(id)
    }
}