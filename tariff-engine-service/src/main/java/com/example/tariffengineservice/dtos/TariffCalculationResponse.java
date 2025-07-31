package com.example.tariffengineservice.dtos;

import java.util.Map;

public class TariffCalculationResponse {

    private String itemId;
    private String country;
    private double itemTariff;
    private double componentTariff;
    private double totalTariff;
    private Map<String, Double> componentBreakdown;

    public TariffCalculationResponse() {}

    public TariffCalculationResponse(String itemId, String country, double itemTariff, double componentTariff, double totalTariff, Map<String, Double> componentBreakdown) {
        this.itemId = itemId;
        this.country = country;
        this.itemTariff = itemTariff;
        this.componentTariff = componentTariff;
        this.totalTariff = totalTariff;
        this.componentBreakdown = componentBreakdown;
    }


    public String getItemId() { return itemId; }
    public void setItemId(String itemId) { this.itemId = itemId; }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    public double getItemTariff() { return itemTariff; }
    public void setItemTariff(double itemTariff) { this.itemTariff = itemTariff; }

    public double getComponentTariff() { return componentTariff; }
    public void setComponentTariff(double componentTariff) { this.componentTariff = componentTariff; }

    public double getTotalTariff() { return totalTariff; }
    public void setTotalTariff(double totalTariff) { this.totalTariff = totalTariff; }

    public Map<String, Double> getComponentBreakdown() { return componentBreakdown; }
    public void setComponentBreakdown(Map<String, Double> componentBreakdown) { this.componentBreakdown = componentBreakdown; }
}
