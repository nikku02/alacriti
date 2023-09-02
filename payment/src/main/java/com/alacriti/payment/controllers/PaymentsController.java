package com.alacriti.payment.controllers;

import com.alacriti.payment.entities.Payment;
import com.alacriti.payment.service.PaymentService;
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

    @GetMapping("/payment/{paymentId}")
    public ResponseEntity<String> getPaymentStatus(@PathVariable String paymentId) {
        return new ResponseEntity<String>(paymentService.checkPaymentStatus(paymentId), HttpStatus.OK);
    }
}
