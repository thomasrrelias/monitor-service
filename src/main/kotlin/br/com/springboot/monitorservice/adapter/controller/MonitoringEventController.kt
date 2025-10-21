package br.com.springboot.monitorservice.adapter.controller

import br.com.springboot.monitorservice.domain.vo.request.CreateEventRequest
import br.com.springboot.monitorservice.domain.vo.request.CreateOrUpdateLocationRequest
import br.com.springboot.monitorservice.usercase.service.MonitoringEventService
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("events")
class MonitoringEventController(
    private val monitoringEventService: MonitoringEventService
) {
    @PostMapping
    fun newEvent(
        @Valid @RequestBody
        newEvent: CreateEventRequest,
    ): ResponseEntity<Any> {
        return ResponseEntity.ok(monitoringEventService.createEvent(newEvent))
    }
}