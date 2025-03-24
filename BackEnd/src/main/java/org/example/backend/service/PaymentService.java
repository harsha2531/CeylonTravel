package org.example.backend.service;

import org.example.backend.dto.PaymentDTO;
import org.example.backend.entity.Booking;
import org.example.backend.entity.Payment;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

public interface PaymentService {
    @Transactional
    public PaymentDTO savePayment(PaymentDTO paymentDto);

    public List<PaymentDTO> getAllPayments();

    public PaymentDTO getPaymentById(Long id);

    @Transactional
    public PaymentDTO updatePayment(Long id, PaymentDTO paymentDto);

    @Transactional
    public void deletePayment(Long id);

    private PaymentDTO mapToDto(Payment payment) {
        return new PaymentDTO(
                payment.getId(),
                payment.getBooking().getId(),
                payment.getAmountPaid(),
                payment.getPaymentDate(),
                payment.getPaymentMethod(),
                payment.getTransactionId()
        );
    }
}
