package org.example.backend.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.BookingDTO;
import org.example.backend.entity.Booking;
import org.example.backend.entity.TourPackage;
import org.example.backend.entity.User;
import org.example.backend.enums.BookingStatus;
import org.example.backend.repo.BookingRepo;
import org.example.backend.repo.TourPackageRepository;
import org.example.backend.repo.UserRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl {

    private final BookingRepo bookingRepository;
    private final UserRepo userRepository;
    private final TourPackageRepository tourPackageRepository;

    @Transactional
    public BookingDTO saveBooking(BookingDTO bookingDto) {
        User traveler = userRepository.findById(bookingDto.getTravelerId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        TourPackage tourPackage = tourPackageRepository.findById(bookingDto.getTourPackageId())
                .orElseThrow(() -> new RuntimeException("Tour Package not found"));

        Booking booking = new Booking();
        booking.setTraveler(traveler);
        booking.setTourPackage(tourPackage);
        booking.setBookingDate(bookingDto.getBookingDate());
        booking.setStatus(BookingStatus.PENDING); // Default status

        Booking savedBooking = bookingRepository.save(booking);
        return mapToDto(savedBooking);
    }

    public List<BookingDTO> getAllBookings() {
        return bookingRepository.findAll().stream().map(this::mapToDto).collect(Collectors.toList());
    }

    public BookingDTO getBookingById(Long id) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));
        return mapToDto(booking);
    }

    @Transactional
    public BookingDTO updateBooking(Long id, BookingDTO bookingDto) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        booking.setBookingDate(bookingDto.getBookingDate());
        booking.setStatus(bookingDto.getStatus());

        Booking updatedBooking = bookingRepository.save(booking);
        return mapToDto(updatedBooking);
    }

    @Transactional
    public void deleteBooking(Long id) {
        if (!bookingRepository.existsById(id)) {
            throw new RuntimeException("Booking not found");
        }
        bookingRepository.deleteById(id);
    }

    private BookingDTO mapToDto(Booking booking) {
        return new BookingDTO(
                booking.getId(),
                booking.getTraveler().getId(),
                booking.getTourPackage().getId(),
                booking.getBookingDate(),
                booking.getStatus()
        );
    }
}
