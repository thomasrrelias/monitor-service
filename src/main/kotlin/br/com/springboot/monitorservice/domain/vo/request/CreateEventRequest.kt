package br.com.springboot.monitorservice.domain.vo.request

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming
import jakarta.validation.constraints.DecimalMax
import jakarta.validation.constraints.DecimalMin
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import java.util.UUID

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class CreateEventRequest (
    @field:NotNull
     val locationId: UUID,

    @field:DecimalMin("0.0")
     val downloadMbps: Double,

    @field:DecimalMin("0.0")
     val uploadMbps: Double,

    @field:Min(0)
     val latencyMs: Int,

    @field:DecimalMin("0.0") @field:DecimalMax("100.0")
     val packetLossPct: Double,

    @field:Min(0)
     val deviceCount: Int,

    @field:DecimalMin("0.0")
     val totalBandwidthMbps: Double,

    @field:Size(max = 64)
     val iface: String,
)