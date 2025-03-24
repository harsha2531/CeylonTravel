package org.example.backend.repo;

import org.example.backend.entity.TourPackage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TourPackageRepo extends JpaRepository<TourPackage, Long> {
    List<TourPackage> findByAgencyId(Long agencyId); // Find by Agency ID (user)
}
