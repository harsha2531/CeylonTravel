package org.example.backend.dto;

import lombok.*;
import org.example.backend.entity.TourPackage;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DestinationDTO {
    private Long id;
    private String destinationName;
    private String description;
    private String imageUrl;
    private List<TourPackage> tourPackages;
}
