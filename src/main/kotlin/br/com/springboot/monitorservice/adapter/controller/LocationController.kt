package br.com.springboot.monitorservice.adapter.controller

import br.com.springboot.monitorservice.adapter.client.http.AuthServiceClient
import br.com.springboot.monitorservice.domain.vo.request.CreateOrUpdateLocationRequest
import br.com.springboot.monitorservice.usercase.service.LocationService
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("locations")
class LocationController(
    private val authServiceClient: AuthServiceClient,
    private val locationService: LocationService
) {

    @PostMapping
    fun newLocation(
        @RequestHeader("Authorization") token: String,
        @Valid @RequestBody
        newLocation: CreateOrUpdateLocationRequest,
    ): ResponseEntity<Any>{
        authServiceClient.validateToken(token)
        return ResponseEntity.ok(locationService.createLocation(newLocation))
    }
}