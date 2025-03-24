package org.example.backend.service;

import org.example.backend.dto.TourPackageDTO;
import org.example.backend.entity.TourPackage;
import org.example.backend.entity.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

public interface TourPackageService {
    @Transactional
    public TourPackageDTO saveTourPackage(TourPackageDTO tourPackageDto);

    public List<TourPackageDTO> getAllTourPackages();

    public TourPackageDTO getTourPackageById(Long id);

    @Transactional
    public TourPackageDTO updateTourPackage(Long id, TourPackageDTO tourPackageDto);

    @Transactional
    public void deleteTourPackage(Long id);

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
