package org.example.backend.service;

import org.example.backend.dto.DestinationDTO;

import java.util.List;

public interface DestinationService {
    DestinationDTO saveDestination(DestinationDTO destinationDTO);
    DestinationDTO updateDestination(Long id, DestinationDTO destinationDTO);
    void deleteDestination(Long id);
    List<DestinationDTO> getAllDestinations();
    DestinationDTO getDestinationById(Long id);
}
