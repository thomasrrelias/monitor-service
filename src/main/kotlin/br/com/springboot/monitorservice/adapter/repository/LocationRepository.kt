package br.com.springboot.monitorservice.adapter.repository

import br.com.springboot.monitorservice.domain.entity.Location
import java.util.UUID
import org.springframework.data.jpa.repository.JpaRepository

interface LocationRepository : JpaRepository<Location, UUID>