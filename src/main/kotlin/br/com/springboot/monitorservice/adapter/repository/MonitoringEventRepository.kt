package br.com.springboot.monitorservice.adapter.repository

import br.com.springboot.monitorservice.domain.entity.MonitoringEvent
import java.util.UUID
import org.springframework.data.jpa.repository.JpaRepository

interface MonitoringEventRepository : JpaRepository<MonitoringEvent, UUID> {
}