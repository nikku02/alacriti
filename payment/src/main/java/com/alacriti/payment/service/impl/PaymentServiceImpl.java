package com.alacriti.payment.service.impl;

import com.alacriti.payment.entities.Payment;
import com.alacriti.payment.repository.PaymentRepository;
import com.alacriti.payment.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Service
@Slf4j
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public String makePayment(Payment payment) {
        try {
            paymentRepository.save(payment);
            return "Payment Successful";
        } catch(Exception e) {
            log.error("Exception occurred "+e.getMessage());
            return "Something went wrong";
        }
    }

    public String checkPaymentStatus(String paymentId) {
        try {
            Payment payment = paymentRepository.findById(paymentId).orElse(null);
            if(Objects.isNull(payment)) {
                return "No such transaction available";
            }
            return "Transaction found";
        } catch(Exception e) {
            log.error("Exception occurred "+e.getMessage());
            return "Something went wrong";
        }
    }
}
