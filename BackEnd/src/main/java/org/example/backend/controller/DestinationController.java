package org.example.backend.controller;


import org.example.backend.dto.DestinationDTO;
import org.example.backend.service.DestinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/destinations")
public class DestinationController {

    @Autowired
    private DestinationService destinationService;

    @PostMapping
    public DestinationDTO saveDestination(@RequestBody DestinationDTO dto) {
        return destinationService.saveDestination(dto);
    }

    @PutMapping("/{id}")
    public DestinationDTO updateDestination(@PathVariable Long id, @RequestBody DestinationDTO dto) {
        return destinationService.updateDestination(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteDestination(@PathVariable Long id) {
        destinationService.deleteDestination(id);
    }

    @GetMapping
    public List<DestinationDTO> getAllDestinations() {
        return destinationService.getAllDestinations();
    }

    @GetMapping("/{id}")
    public DestinationDTO getDestinationById(@PathVariable Long id) {
        return destinationService.getDestinationById(id);
    }
}
