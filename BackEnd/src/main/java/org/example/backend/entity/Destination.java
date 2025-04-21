package org.example.backend.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "destinations")
public class Destination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String destinationName;
    private String description;
    private String imageUrl;

    @OneToMany(mappedBy = "destination", cascade = CascadeType.ALL)
    private List<TourPackage> tourPackages;

    public Destination() {}

    public Destination(Long id, String destinationName, String description, String imageUrl, List<TourPackage> tourPackages) {
        this.id = id;
        this.destinationName = destinationName;
        this.description = description;
        this.imageUrl = imageUrl;
        this.tourPackages = tourPackages;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDestinationName() {
        return destinationName;
    }

    public void setDestinationName(String destinationName) {
        this.destinationName = destinationName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<TourPackage> getTourPackages() {
        return tourPackages;
    }

    public void setTourPackages(List<TourPackage> tourPackages) {
        this.tourPackages = tourPackages;
    }
}
