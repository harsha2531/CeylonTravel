package org.example.backend.dto;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;
import org.example.backend.entity.Booking;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ItineraryDTO{
    private Long id;
    private String activity;
    private LocalDate date;
    private String location;
}
