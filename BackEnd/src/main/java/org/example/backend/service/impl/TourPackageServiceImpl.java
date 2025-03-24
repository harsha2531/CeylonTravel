package org.example.backend.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.TourPackageDTO;

import org.example.backend.entity.TourPackage;
import org.example.backend.entity.User;
import org.example.backend.repo.TourPackageRepo;
import org.example.backend.repo.UserRepo;
import org.example.backend.service.TourPackageService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TourPackageServiceImpl implements TourPackageService {

    private final TourPackageRepo tourPackageRepository;
    private final UserRepo userRepository;

    @Transactional
    public TourPackageDTO saveTourPackage(TourPackageDTO tourPackageDto) {
        User agency = userRepository.findById(tourPackageDto.getAgencyId())
                .orElseThrow(() -> new RuntimeException("Agency not found"));

        TourPackage tourPackage = new TourPackage();
        tourPackage.setPackageName(tourPackageDto.getPackageName());
        tourPackage.setDescription(tourPackageDto.getDescription());
        tourPackage.setPrice(tourPackageDto.getPrice());
        tourPackage.setDuration(tourPackageDto.getDuration());
        tourPackage.setLocation(tourPackageDto.getLocation());
        tourPackage.setImageUrl(tourPackageDto.getImageUrl());
        tourPackage.setAgency(agency);

        TourPackage savedTourPackage = tourPackageRepository.save(tourPackage);
        return mapToDto(savedTourPackage);
    }

    public List<TourPackageDTO> getAllTourPackages() {
        return tourPackageRepository.findAll().stream().map(this::mapToDto).collect(Collectors.toList());
    }

    public TourPackageDTO getTourPackageById(Long id) {
        TourPackage tourPackage = tourPackageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tour Package not found"));
        return mapToDto(tourPackage);
    }

    @Transactional
    public TourPackageDTO updateTourPackage(Long id, TourPackageDTO tourPackageDto) {
        TourPackage tourPackage = tourPackageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tour Package not found"));

        tourPackage.setPackageName(tourPackageDto.getPackageName());
        tourPackage.setDescription(tourPackageDto.getDescription());
        tourPackage.setPrice(tourPackageDto.getPrice());
        tourPackage.setDuration(tourPackageDto.getDuration());
        tourPackage.setLocation(tourPackageDto.getLocation());
        tourPackage.setImageUrl(tourPackageDto.getImageUrl());

        TourPackage updatedTourPackage = tourPackageRepository.save(tourPackage);
        return mapToDto(updatedTourPackage);
    }

    @Transactional
    public void deleteTourPackage(Long id) {
        if (!tourPackageRepository.existsById(id)) {
            throw new RuntimeException("Tour Package not found");
        }
        tourPackageRepository.deleteById(id);
    }

    private TourPackageDTO mapToDto(TourPackage tourPackage) {
        return new TourPackageDTO(
                tourPackage.getId(),
                tourPackage.getPackageName(),
                tourPackage.getDescription(),
                tourPackage.getPrice(),
                tourPackage.getDuration(),
                tourPackage.getLocation(),
                tourPackage.getImageUrl(),
                tourPackage.getAgency().getId() // Map agency id
        );
    }
}
