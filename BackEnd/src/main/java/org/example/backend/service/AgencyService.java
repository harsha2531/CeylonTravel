package org.example.backend.service;

import org.example.backend.dto.AgencyDTO;
import org.example.backend.entity.Agency;

import java.util.List;
import java.util.stream.Collectors;

public interface AgencyService {

    public AgencyDTO saveAgency(AgencyDTO dto) ;

    public AgencyDTO updateAgency(Long id, AgencyDTO dto);

    public void deleteAgency(Long id);

    public List<AgencyDTO> getAllAgency();

    public AgencyDTO getAgencyById(Long id);
}
