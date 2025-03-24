package org.example.backend.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.PaymentDTO;
import org.example.backend.entity.Booking;
import org.example.backend.entity.Payment;
import org.example.backend.repo.BookingRepo;
import org.example.backend.repo.PaymentRepo;
import org.example.backend.service.PaymentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepo paymentRepository;
    private final BookingRepo bookingRepository;

    @Transactional
    public PaymentDTO savePayment(PaymentDTO paymentDto) {
        Booking booking = bookingRepository.findById(paymentDto.getBookingId())
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        Payment payment = new Payment();
        payment.setBooking(booking);
        payment.setAmountPaid(paymentDto.getAmountPaid());
        payment.setPaymentDate(paymentDto.getPaymentDate());
        payment.setPaymentMethod(paymentDto.getPaymentMethod());
        payment.setTransactionId(paymentDto.getTransactionId());

        Payment savedPayment = paymentRepository.save(payment);
        return mapToDto(savedPayment);
    }

    public List<PaymentDTO> getAllPayments() {
        return paymentRepository.findAll().stream().map(this::mapToDto).collect(Collectors.toList());
    }

    public PaymentDTO getPaymentById(Long id) {
        Payment payment = paymentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found"));
        return mapToDto(payment);
    }

    @Transactional
    public PaymentDTO updatePayment(Long id, PaymentDTO paymentDto) {
        Payment payment = paymentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found"));

        payment.setAmountPaid(paymentDto.getAmountPaid());
        payment.setPaymentDate(paymentDto.getPaymentDate());
        payment.setPaymentMethod(paymentDto.getPaymentMethod());
        payment.setTransactionId(paymentDto.getTransactionId());

        Payment updatedPayment = paymentRepository.save(payment);
        return mapToDto(updatedPayment);
    }

    @Transactional
    public void deletePayment(Long id) {
        if (!paymentRepository.existsById(id)) {
            throw new RuntimeException("Payment not found");
        }
        paymentRepository.deleteById(id);
    }

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
