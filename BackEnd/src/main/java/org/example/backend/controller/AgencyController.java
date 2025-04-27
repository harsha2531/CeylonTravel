package org.example.backend.controller;


import org.example.backend.dto.AgencyDTO;
import org.example.backend.dto.DestinationDTO;
import org.example.backend.service.AgencyService;
import org.example.backend.service.DestinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agency")
public class AgencyController {

    @Autowired
    private AgencyService agencyService;

    @PostMapping
    public AgencyDTO saveAgency(@RequestBody AgencyDTO dto) {
        return agencyService.saveAgency(dto);
    }

    @PutMapping("/{id}")
    public AgencyDTO updateAgency(@PathVariable Long id, @RequestBody AgencyDTO dto) {
        return agencyService.updateAgency(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteAgency(@PathVariable Long id) {
        agencyService.deleteAgency(id);
    }

    @GetMapping
    public List<AgencyDTO> getAllAgency() {
        return agencyService.getAllAgency();
    }

    @GetMapping("/{id}")
    public AgencyDTO getAgencyById(@PathVariable Long id) {
        return agencyService.getAgencyById(id);
    }
}
