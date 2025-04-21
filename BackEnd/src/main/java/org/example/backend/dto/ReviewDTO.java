package org.example.backend.dto;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;
import org.example.backend.entity.TourPackage;
import org.example.backend.entity.User;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReviewDTO {
    private Long id;
    private Integer rating; // 1 to 5
    private String comment;
    private LocalDate reviewDate;

}
