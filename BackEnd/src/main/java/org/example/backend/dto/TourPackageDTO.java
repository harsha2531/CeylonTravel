package org.example.backend.dto;

import java.math.BigDecimal;

public class TourPackageDTO {
    private Long id;
    private String packageName;
    private String description;
    private int duration;
    private BigDecimal price;
    private String destination;

    public TourPackageDTO() {}

    public TourPackageDTO(Long id, String packageName, String description, int duration, BigDecimal price, String destination) {
        this.id = id;
        this.packageName = packageName;
        this.description = description;
        this.duration = duration;
        this.price = price;
        this.destination = destination;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}
