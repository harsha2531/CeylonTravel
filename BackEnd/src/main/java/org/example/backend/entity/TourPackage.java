package org.example.backend.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tour_packages")
public class TourPackage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String packageName;
    private String description;
    private Double price;
    private Integer duration; // In days
    private String location;
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "agency_id")
    private User agency; // Only travel agencies can create packages

    @OneToMany(mappedBy = "tourPackage", cascade = CascadeType.ALL)
    private List<Booking> bookings;

    @ManyToOne
    @JoinColumn(name = "destination_id")
    private Destination destination;

    public TourPackage() {}

    public TourPackage(Long id, String packageName, String description, Double price, Integer duration, String location, String imageUrl, User agency, List<Booking> bookings) {
        this.id = id;
        this.packageName = packageName;
        this.description = description;
        this.price = price;
        this.duration = duration;
        this.location = location;
        this.imageUrl = imageUrl;
        this.agency = agency;
        this.bookings = bookings;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public User getAgency() {
        return agency;
    }

    public void setAgency(User agency) {
        this.agency = agency;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }
}
