package org.example.backend.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AgencyDTO {
    private Long id;
    private String name;
    private String contactNumber;
    private String location;

}
