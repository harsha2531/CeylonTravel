package org.example.backend.repo;

import org.example.backend.entity.Booking;
import org.example.backend.enums.BookingStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepo extends JpaRepository<Booking, Long> {
    List<Booking> findByTravelerId(Long travelerId);
    List<Booking> findByStatus(BookingStatus status);
}
