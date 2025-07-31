package com.example.tariffruleservice.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tariff_rules")
public class TariffRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String level; // item or component

    @Column(name = "entity_id", nullable = false)
    private String entityId; // ITEM123 or COMPONENT456

    @Column(nullable = false)
    private String country; // e.g. CHN, USA

    @Column(name = "tariff_rate", nullable = false)
    private Double tariffRate;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(nullable = false)
    private String source; // Policy source

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getLevel() { return level; }
    public void setLevel(String level) { this.level = level; }

    public String getEntityId() { return entityId; }
    public void setEntityId(String entityId) { this.entityId = entityId; }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    public Double getTariffRate() { return tariffRate; }
    public void setTariffRate(Double tariffRate) { this.tariffRate = tariffRate; }

    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }

    public String getSource() { return source; }
    public void setSource(String source) { this.source = source; }
}
