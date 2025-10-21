package br.com.springboot.monitorservice.usercase.converter

import br.com.springboot.monitorservice.domain.entity.Location
import br.com.springboot.monitorservice.domain.entity.LocationType
import br.com.springboot.monitorservice.domain.vo.request.CreateOrUpdateLocationRequest
import org.springframework.stereotype.Component


@Component
class LocationConverter {
    fun convert(location: CreateOrUpdateLocationRequest): Location =
        Location(
            locationId = location.locationId,
            name = location.ownerName,
            ownerEmail = location.ownerEmail,
            locationType = location.locationType
        )
}