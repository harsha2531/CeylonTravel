package org.example.backend.dto;

import lombok.*;
import org.example.backend.enums.BookingStatus;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BookingDTO {
    private Long id;
    private Long travelerId;
    private Long tourPackageId;
    private LocalDate bookingDate;
    private BookingStatus status;
}
