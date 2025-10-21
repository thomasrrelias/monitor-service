package br.com.springboot.monitorservice.usercase.service

import br.com.springboot.monitorservice.adapter.repository.LocationRepository
import br.com.springboot.monitorservice.domain.vo.request.CreateOrUpdateLocationRequest
import br.com.springboot.monitorservice.usercase.converter.LocationConverter
import org.springframework.stereotype.Service

@Service
class LocationService(
    private val locationConverter: LocationConverter,
    private val locationRepository: LocationRepository
){
    fun createLocation(newLocation: CreateOrUpdateLocationRequest){
        val location = locationConverter.convert(newLocation)
        locationRepository.save(location)
    }
}