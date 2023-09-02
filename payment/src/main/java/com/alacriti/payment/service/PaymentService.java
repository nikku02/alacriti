package com.alacriti.payment.service;


import com.alacriti.payment.entities.Payment;

public interface PaymentService {

    public String makePayment(Payment payment);

    public String checkPaymentStatus(String paymentId);
}
