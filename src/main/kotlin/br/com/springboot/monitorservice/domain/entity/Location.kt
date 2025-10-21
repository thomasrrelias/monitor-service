package br.com.springboot.monitorservice.domain.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import java.util.UUID

@Entity
@Table(name = "locations")
class Location(
    @Id
    @Column(nullable = false, unique = true)
    val locationId: UUID,
    @Column(nullable = false)
    var name: String,
    @Column(nullable = false, unique = true)
    var ownerEmail: String,
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    val locationType: LocationType,
    @OneToMany(mappedBy = "location")
    val monitoringEvents: MutableSet<MonitoringEvent> = mutableSetOf()
)