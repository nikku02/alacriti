package com.alacriti.payment.controllers;

import com.alacriti.payment.entities.Merchant;
import com.alacriti.payment.service.MerchantSerivice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MerchantController {

    @Autowired
    private MerchantSerivice merchantSerivice;

    @PostMapping("/register")
    public ResponseEntity<String> registerMerchant(@RequestBody Merchant merchant) {
        return new ResponseEntity<>(merchantSerivice.registerMerchant(merchant), HttpStatus.OK);
    }
}
