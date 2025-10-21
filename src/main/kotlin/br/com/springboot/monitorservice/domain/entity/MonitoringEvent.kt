package br.com.springboot.monitorservice.domain.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.time.Instant
import java.util.UUID

@Entity
@Table(name = "monitoring")
class MonitoringEvent(
    @Id
    @Column(nullable = false, unique = true)
    val id: UUID = UUID.randomUUID(),
    @ManyToOne
    @JoinColumn(name = "location_id")
    var location: Location? = null,
    @Column( nullable = false)
    val occurredAt: Instant = Instant.now(),
    @Column(nullable = false)
    var downloadMbps: Double,
    @Column(nullable = false)
    var uploadMbps: Double? = null,
    @Column(nullable = false)
    var latencyMs: Int? = null,
    @Column(nullable = false)
    var packetLossPct: Double? = null,
    @Column(nullable = false)
    var deviceCount: Int? = null,
    @Column(nullable = false)
    var totalBandwidthMbps: Double,
    @Column(name = "iface", length = 64)
    var iface: String,
)