package org.example.backend.dto;

import lombok.*;

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
}
