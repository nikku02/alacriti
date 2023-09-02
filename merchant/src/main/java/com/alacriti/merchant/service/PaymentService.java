package com.alacriti.merchant.service;

import com.alacriti.merchant.entities.Payment;

public interface PaymentService {

    public String makePayment(Payment payment);

    public String checkPaymentStatus(String paymentId);
}
