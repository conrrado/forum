package com.conrradocamacho.forum.controller

import com.conrradocamacho.forum.dto.AnswerForm
import com.conrradocamacho.forum.dto.AnswerView
import com.conrradocamacho.forum.dto.UpdatedAnswerForm
import com.conrradocamacho.forum.service.AnswerService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/answers")
class AnswerController(private val service: AnswerService) {

    @GetMapping("/topic/{topicId}")
    fun listByTopicId(@PathVariable topicId: Long): List<AnswerView> {
        return service.listByTopicId(topicId)
    }

    @PostMapping
    fun register(
        @RequestBody @Valid form: AnswerForm,
        uriComponentsBuilder: UriComponentsBuilder
    ): ResponseEntity<AnswerView> {
        val answerView = service.register(form)
        val uri = uriComponentsBuilder.path("/answers/${answerView.id}").build().toUri()
        return ResponseEntity.created(uri).body(answerView)
    }

    @PutMapping
    fun update(@RequestBody @Valid form: UpdatedAnswerForm): ResponseEntity<AnswerView> {
        val answerView = service.update(form)
        return ResponseEntity.ok(answerView)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun remove(@PathVariable id: Long) {
        service.remove(id)
    }
}