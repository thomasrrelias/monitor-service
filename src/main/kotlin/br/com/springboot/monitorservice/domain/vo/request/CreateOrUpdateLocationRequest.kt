package br.com.springboot.monitorservice.domain.vo.request

import br.com.springboot.monitorservice.domain.entity.LocationType
import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming
import java.util.UUID
import org.jetbrains.annotations.NotNull

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class CreateOrUpdateLocationRequest(
    @field:NotNull
    val locationId: UUID,
    @field:NotNull
    val ownerName: String,
    @field:NotNull
    val ownerEmail: String,
    @field:NotNull
    val locationType: LocationType
)
