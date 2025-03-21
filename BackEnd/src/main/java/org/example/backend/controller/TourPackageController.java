package org.example.backend.controller;

import org.example.backend.dto.TourPackageDTO;
import org.example.backend.service.TourPackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tour-packages")
public class TourPackageController {

    @Autowired
    private TourPackageService tourPackageService;

    @GetMapping
    public ResponseEntity<List<TourPackageDTO>> getAllPackages() {
        return ResponseEntity.ok(tourPackageService.getAllPackages());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TourPackageDTO> getPackageById(@PathVariable int id) {
        return ResponseEntity.ok(tourPackageService.getPackageById(id));
    }

    @PostMapping
    public ResponseEntity<TourPackageDTO> createPackage(@RequestBody TourPackageDTO dto) {
        return ResponseEntity.ok(tourPackageService.savePackage(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TourPackageDTO> updatePackage(@PathVariable int id, @RequestBody TourPackageDTO dto) {
        return ResponseEntity.ok(tourPackageService.updatePackage(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePackage(@PathVariable int id) {
        return tourPackageService.deletePackage(id) ? ResponseEntity.ok("Package deleted successfully") : ResponseEntity.notFound().build();
    }
}
