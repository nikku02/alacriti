package com.alacriti.merchant.service.impl;

import com.alacriti.merchant.entities.Payment;
import com.alacriti.merchant.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class PaymentServiceImpl implements PaymentService {


    RestTemplate restTemplate = new RestTemplate();

    @Value("${payment.service.base.url}")
    private String paymentServiceUrl;

    @Override
    public String makePayment(Payment payment) {
        try {
            ResponseEntity<String> response = restTemplate.postForEntity(paymentServiceUrl+"/api/payment", payment, String.class);
            return response.getBody();
        } catch(Exception e) {
            log.error("Exception occurred "+e.getMessage());
            return "Something went wrong";
        }
    }

    public String checkPaymentStatus(String paymentId) {
        try {
            ResponseEntity<String> response = restTemplate.getForEntity(paymentServiceUrl+"/api/payment/"+paymentId, String.class);
            return response.getBody();
        } catch(Exception e) {
            log.error("Exception occurred "+e.getMessage());
            return "Something went wrong";
        }
    }
}
