package com.example.bomresolverservice.entity;

import javax.persistence.*;

@Entity
@Table(name = "components")
public class Component {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "component_id", nullable = false)
    private String componentId; // e.g. STEEL_A

    @Column(nullable = false)
    private String description; // e.g. Steel

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id_fk")
    private Item item;

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getComponentId() { return componentId; }
    public void setComponentId(String componentId) { this.componentId = componentId; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Item getItem() { return item; }
    public void setItem(Item item) { this.item = item; }
}
