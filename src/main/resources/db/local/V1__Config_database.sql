CREATE EXTENSION IF NOT EXISTS pgcrypto;

-- ===== TABELA: locations =====
CREATE TABLE IF NOT EXISTS locations (
                                         location_id   UUID PRIMARY KEY,
                                         name          VARCHAR(255) NOT NULL,
    owner_email   VARCHAR(255) NOT NULL UNIQUE,
    location_type VARCHAR(20)  NOT NULL,
    CONSTRAINT locations_location_type_chk
    CHECK (location_type IN ('HOUSE','APARTMENT','SHOP','FACTORY'))
    );

-- (REMOVIDO índice redundante em owner_email)

-- ===== TABELA: monitoring =====
CREATE TABLE IF NOT EXISTS monitoring (
                                          id                    UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    location_id           UUID NOT NULL,
    occurred_at           TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    download_mbps         DOUBLE PRECISION NOT NULL,
    upload_mbps           DOUBLE PRECISION NOT NULL,    -- torne NULL se quiser permitir nulos
    latency_ms            INTEGER NOT NULL,             -- torne NULL se quiser permitir nulos
    packet_loss_pct       DOUBLE PRECISION NOT NULL,    -- torne NULL se quiser permitir nulos
    device_count          INTEGER NOT NULL,             -- torne NULL se quiser permitir nulos
    total_bandwidth_mbps  DOUBLE PRECISION NOT NULL,
    iface                 VARCHAR(64) NOT NULL,

    CONSTRAINT fk_monitoring_location
    FOREIGN KEY (location_id)
    REFERENCES locations(location_id)
    ON DELETE CASCADE,

    CONSTRAINT chk_monitoring_non_negative
    CHECK (
              download_mbps >= 0 AND
              upload_mbps  >= 0 AND
              latency_ms   >= 0 AND
              packet_loss_pct BETWEEN 0 AND 100 AND
              device_count >= 0 AND
              total_bandwidth_mbps >= 0
          )
    );

-- Índices úteis
CREATE INDEX IF NOT EXISTS idx_monitoring_location_occurred
    ON monitoring (location_id, occurred_at DESC);

CREATE INDEX IF NOT EXISTS idx_monitoring_iface
    ON monitoring (iface);
