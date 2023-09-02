package com.alacriti.merchant.controllers;

import com.alacriti.merchant.entities.Payment;
import com.alacriti.merchant.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PaymentsController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/payment")
    public ResponseEntity<String> makePayment(@RequestBody Payment payment) {
        return new ResponseEntity<String>(paymentService.makePayment(payment), HttpStatus.OK);
    }

    @GetMapping("/payment_status/{paymentId}")
    public ResponseEntity<String> getPaymentStatus(@PathVariable String paymentId) {
        return new ResponseEntity<String>(paymentService.checkPaymentStatus(paymentId), HttpStatus.OK);
    }
}
