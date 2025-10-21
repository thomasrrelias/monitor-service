package br.com.springboot.monitorservice.usercase.service

import br.com.springboot.monitorservice.adapter.repository.LocationRepository
import br.com.springboot.monitorservice.adapter.repository.MonitoringEventRepository
import br.com.springboot.monitorservice.domain.vo.request.CreateEventRequest
import br.com.springboot.monitorservice.usercase.converter.MonitoringEventConvert
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class MonitoringEventService(
    private val locationRepository: LocationRepository,
    private val monitoringEventRepository: MonitoringEventRepository,
    private val eventConvert: MonitoringEventConvert,
    ){
    @Transactional
    fun createEvent(newEvent: CreateEventRequest) {
        val location = locationRepository.findById(newEvent.locationId)
            .orElseThrow { IllegalArgumentException("Location não encontrada: ${newEvent.locationId}") }
        val event = eventConvert.convert(newEvent, location)
        monitoringEventRepository.save(event)
        locationRepository.save(location)
    }
}