package org.example.backend.service.impl;

import org.example.backend.dto.TourPackageDTO;
import org.example.backend.entity.TourPackage;
import org.example.backend.repo.TourPackageRepository;
import org.example.backend.service.TourPackageService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TourPackageServiceImpl implements TourPackageService {
    @Autowired
    private TourPackageRepository tourPackageRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<TourPackageDTO> getAllPackages() {
        return tourPackageRepository.findAll().stream()
                .map(packageEntity -> modelMapper.map(packageEntity, TourPackageDTO.class))
                .collect(Collectors.toList());
    }


    public TourPackageDTO getPackageById(int id) {
        return tourPackageRepository.findById(id)
                .map(packageEntity -> modelMapper.map(packageEntity, TourPackageDTO.class))
                .orElse(null);
    }

    public TourPackageDTO savePackage(TourPackageDTO dto) {
        TourPackage tourPackage = modelMapper.map(dto, TourPackage.class);
        tourPackage = tourPackageRepository.save(tourPackage);
        return modelMapper.map(tourPackage, TourPackageDTO.class);
    }

    public TourPackageDTO updatePackage(int id, TourPackageDTO dto) {
        if (tourPackageRepository.existsById(id)) {
            TourPackage tourPackage = modelMapper.map(dto, TourPackage.class);
            tourPackage.setId(id);
            return modelMapper.map(tourPackageRepository.save(tourPackage), TourPackageDTO.class);
        }
        return null;
    }

    public boolean deletePackage(int id) {
        if (tourPackageRepository.existsById(id)) {
            tourPackageRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
