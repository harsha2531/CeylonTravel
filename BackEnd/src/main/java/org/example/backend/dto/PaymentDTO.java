package org.example.backend.dto;

import lombok.*;
import org.example.backend.enums.PaymentMethod;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PaymentDTO {
    private Long id;
    private Long bookingId;
    private Double amountPaid;
    private LocalDate paymentDate;
    private PaymentMethod paymentMethod;
    private String transactionId;
}
