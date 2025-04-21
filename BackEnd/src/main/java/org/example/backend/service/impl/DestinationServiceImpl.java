package org.example.backend.service.impl;

import org.example.backend.dto.DestinationDTO;
import org.example.backend.entity.Destination;
import org.example.backend.repo.DestinationRepo;
import org.example.backend.service.DestinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DestinationServiceImpl implements DestinationService {

    @Autowired
    private DestinationRepo destinationRepository;

    @Override
    public DestinationDTO saveDestination(DestinationDTO dto) {
        Destination destination = new Destination(dto.getId(), dto.getDestinationName(), dto.getDescription(), dto.getImageUrl(),dto.getTourPackages());
        Destination saved = destinationRepository.save(destination);
        return new DestinationDTO(saved.getId(), saved.getDestinationName(), saved.getDescription(), saved.getImageUrl(),saved.getTourPackages());
    }

    @Override
    public DestinationDTO updateDestination(Long id, DestinationDTO dto) {
        Destination destination = destinationRepository.findById(id).orElseThrow(() -> new RuntimeException("Destination not found"));
        destination.setDestinationName(dto.getDestinationName());
        destination.setDescription(dto.getDescription());
        destination.setImageUrl(dto.getImageUrl());
        Destination updated = destinationRepository.save(destination);
        return new DestinationDTO(updated.getId(), updated.getDestinationName(), updated.getDescription(), updated.getImageUrl(),updated.getTourPackages());
    }

    @Override
    public void deleteDestination(Long id) {
        destinationRepository.deleteById(id);
    }

    @Override
    public List<DestinationDTO> getAllDestinations() {
        return destinationRepository.findAll().stream()
                .map(dest -> new DestinationDTO(dest.getId(), dest.getDestinationName(), dest.getDescription(), dest.getImageUrl(),dest.getTourPackages()))
                .collect(Collectors.toList());
    }

    @Override
    public DestinationDTO getDestinationById(Long id) {
        Destination dest = destinationRepository.findById(id).orElseThrow(() -> new RuntimeException("Destination not found"));
        return new DestinationDTO(dest.getId(), dest.getDestinationName(), dest.getDescription(), dest.getImageUrl(),dest.getTourPackages());
    }
}
