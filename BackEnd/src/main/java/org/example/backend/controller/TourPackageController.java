package org.example.backend.controller;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.TourPackageDTO;
import org.example.backend.service.TourPackageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tour-packages")
@RequiredArgsConstructor
public class TourPackageController {

    private final TourPackageService tourPackageService;

    @PostMapping
    public ResponseEntity<TourPackageDTO> createTourPackage(@RequestBody TourPackageDTO tourPackageDto) {
        return ResponseEntity.ok(tourPackageService.saveTourPackage(tourPackageDto));
    }

    @GetMapping
    public ResponseEntity<List<TourPackageDTO>> getAllTourPackages() {
        return ResponseEntity.ok(tourPackageService.getAllTourPackages());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TourPackageDTO> getTourPackageById(@PathVariable Long id) {
        return ResponseEntity.ok(tourPackageService.getTourPackageById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TourPackageDTO> updateTourPackage(@PathVariable Long id, @RequestBody TourPackageDTO tourPackageDto) {
        return ResponseEntity.ok(tourPackageService.updateTourPackage(id, tourPackageDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTourPackage(@PathVariable Long id) {
        tourPackageService.deleteTourPackage(id);
        return ResponseEntity.ok("Tour Package deleted successfully");
    }
}
