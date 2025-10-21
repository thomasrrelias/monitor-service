package br.com.springboot.monitorservice.usercase.converter

import br.com.springboot.monitorservice.domain.entity.Location
import br.com.springboot.monitorservice.domain.entity.MonitoringEvent
import br.com.springboot.monitorservice.domain.vo.request.CreateEventRequest
import org.springframework.stereotype.Component

@Component
class MonitoringEventConvert {

    fun convert( event: CreateEventRequest, location: Location): MonitoringEvent =
        MonitoringEvent(
            location = location,
            downloadMbps = event.downloadMbps,
            uploadMbps = event.uploadMbps,
            latencyMs = event.latencyMs,
            packetLossPct = event.packetLossPct,
            deviceCount = event.deviceCount,
            totalBandwidthMbps = event.totalBandwidthMbps,
            iface = event.iface
        )
}