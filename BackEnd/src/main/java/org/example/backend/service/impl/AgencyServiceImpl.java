package org.example.backend.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.AgencyDTO;
import org.example.backend.dto.DestinationDTO;
import org.example.backend.entity.Agency;
import org.example.backend.entity.Destination;
import org.example.backend.repo.AgencyRepo;
import org.example.backend.repo.DestinationRepo;
import org.example.backend.service.AgencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AgencyServiceImpl implements AgencyService {
    @Autowired
    private AgencyRepo agencyRepo;

    @Override
    public AgencyDTO saveAgency(AgencyDTO dto) {
        Agency agency = new Agency(dto.getId(), dto.getName(), dto.getLocation(), dto.getContactNumber());
        Agency saved = agencyRepo.save(agency);
        return new AgencyDTO(saved.getId(), saved.getName(), saved.getLocation(), saved.getContactNumber());
    }

    @Override
    public AgencyDTO updateAgency(Long id, AgencyDTO dto) {
        Agency agency = agencyRepo.findById(id).orElseThrow(() -> new RuntimeException("Agency not found"));
        agency.setName(dto.getName());
        agency.setContactNumber(dto.getContactNumber());
        agency.setLocation(dto.getLocation());
        Agency updated = agencyRepo.save(agency);
        return new AgencyDTO(updated.getId(), updated.getName(), updated.getLocation(), updated.getContactNumber());
    }

    @Override
    public void deleteAgency(Long id) {
        agencyRepo.deleteById(id);
    }

    @Override
    public List<AgencyDTO> getAllAgency() {
        return agencyRepo.findAll().stream()
                .map(dest -> new AgencyDTO(dest.getId(), dest.getName(), dest.getLocation(), dest.getContactNumber()))
                .collect(Collectors.toList());
    }

    @Override
    public AgencyDTO getAgencyById(Long id) {
        Agency agency = agencyRepo.findById(id).orElseThrow(() -> new RuntimeException("Agency not found"));
        return new AgencyDTO(agency.getId(), agency.getName(), agency.getLocation(), agency.getContactNumber());
    }
}
