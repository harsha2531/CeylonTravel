package org.example.backend.service;

import org.example.backend.dto.TourPackageDTO;
import org.example.backend.entity.TourPackage;

import java.util.List;
import java.util.stream.Collectors;

public interface TourPackageService {
    public List<TourPackageDTO> getAllPackages();


    public TourPackageDTO getPackageById(int id);

    public TourPackageDTO savePackage(TourPackageDTO dto);

    public TourPackageDTO updatePackage(int id, TourPackageDTO dto);

    public boolean deletePackage(int id);
}
