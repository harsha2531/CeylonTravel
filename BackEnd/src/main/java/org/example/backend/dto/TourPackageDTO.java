package org.example.backend.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TourPackageDTO {
    private Long id;
    private String packageName;
    private String description;
    private Double price;
    private Integer duration; // In days
    private String location;
    private String imageUrl;
    private Long agencyId; // Foreign key to Agency (User)
}
