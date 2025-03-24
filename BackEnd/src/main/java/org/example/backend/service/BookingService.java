package org.example.backend.service;

import org.example.backend.dto.BookingDTO;
import org.example.backend.entity.Booking;
import org.example.backend.entity.TourPackage;
import org.example.backend.entity.User;
import org.example.backend.enums.BookingStatus;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

public interface BookingService {
    public BookingDTO saveBooking(BookingDTO bookingDto);

    public List<BookingDTO> getAllBookings();

    public BookingDTO getBookingById(Long id);
    @Transactional
    public BookingDTO updateBooking(Long id, BookingDTO bookingDto);
    @Transactional
    public void deleteBooking(Long id);

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
