package com.example.tariffengineservice.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tariff_rule")
public class TariffRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String level;         // "item" or "component"
    private String entityId;      // ITEM123 or COMPONENT_X
    private String country;
    private double tariffRate;
    private LocalDate startDate;
    private String source;        // e.g. President 3 Policy

    public TariffRule() {}

    public TariffRule(Long id, String level, String entityId, String country, double tariffRate, LocalDate startDate, String source) {
        this.id = id;
        this.level = level;
        this.entityId = entityId;
        this.country = country;
        this.tariffRate = tariffRate;
        this.startDate = startDate;
        this.source = source;
    }


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getLevel() { return level; }
    public void setLevel(String level) { this.level = level; }

    public String getEntityId() { return entityId; }
    public void setEntityId(String entityId) { this.entityId = entityId; }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    public double getTariffRate() { return tariffRate; }
    public void setTariffRate(double tariffRate) { this.tariffRate = tariffRate; }

    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }

    public String getSource() { return source; }
    public void setSource(String source) { this.source = source; }
}
