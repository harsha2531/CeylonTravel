package org.example.backend.controller;


import org.example.backend.dto.AgencyDTO;
import org.example.backend.dto.DestinationDTO;
import org.example.backend.dto.UserDTO;
import org.example.backend.service.AgencyService;
import org.example.backend.service.DestinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/agency")
@CrossOrigin(origins = "http://localhost:63342", allowedHeaders = "*")
public class AgencyController {

    @Autowired
    private AgencyService agencyService;

    @PostMapping("/save")
    public AgencyDTO saveAgency(@RequestBody AgencyDTO dto) {
        return agencyService.saveAgency(dto);
    }

    @PutMapping("/update/{id}")
    public AgencyDTO updateAgency(@PathVariable Long id, @RequestBody AgencyDTO dto) {
        return agencyService.updateAgency(id, dto);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAgency(@PathVariable Long id) {
        agencyService.deleteAgency(id);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<AgencyDTO>> getAllAgency() {
        List<AgencyDTO> users = agencyService.getAllAgency();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public AgencyDTO getAgencyById(@PathVariable Long id) {
        return agencyService.getAgencyById(id);
    }
}
