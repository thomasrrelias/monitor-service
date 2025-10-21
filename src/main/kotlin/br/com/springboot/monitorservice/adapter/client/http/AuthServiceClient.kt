package br.com.springboot.monitorservice.adapter.client.http

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader

@FeignClient(
    value = "authSeviceClient",
    url = "\${auth-service.url}",
)
interface AuthServiceClient {

    @GetMapping("/auth/validate-token")
    fun validateToken(
        @RequestHeader("Authorization") token: String,
    ): ResponseEntity<String>

    @PostMapping("/auth/validate-profiles")
    fun validateProfiles(
        @RequestHeader("Authorization") token: String,
        @RequestBody requiredProfiles: List<String>,
    ): ResponseEntity<String>
}
