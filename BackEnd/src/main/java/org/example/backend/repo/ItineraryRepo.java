package org.example.backend.repo;

import org.example.backend.entity.Itinerary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItineraryRepo extends JpaRepository<Itinerary, Long> {
    // You can define custom query methods if needed
}
