package org.example.backend.repo;

import org.example.backend.entity.TourPackage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TourPackageRepository extends JpaRepository<TourPackage, Integer> {
}
