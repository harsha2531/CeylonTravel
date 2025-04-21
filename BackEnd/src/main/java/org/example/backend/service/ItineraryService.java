package org.example.backend.service;

import org.example.backend.entity.Itinerary;

import java.util.List;
import java.util.Optional;

public interface ItineraryService {
    public Itinerary saveItinerary(Itinerary itinerary);

    public List<Itinerary> getAllItineraries();

    public Optional<Itinerary> getItineraryById(Long id);

    public void deleteItinerary(Long id);

    public Itinerary updateItinerary(Itinerary itinerary);
}
