package com.alacriti.merchant.service.impl;

import com.alacriti.merchant.entities.Merchant;
import com.alacriti.merchant.service.MerchantSerivice;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class MerchantServiceImpl implements MerchantSerivice {

    RestTemplate restTemplate = new RestTemplate();

    @Value("${payment.service.base.url}")
    private String paymentServiceUrl;


    @Override
    public String registerMerchant(Merchant merchant) {
        try {
            ResponseEntity<String> response = restTemplate.postForEntity(paymentServiceUrl+"/api/register", merchant, String.class);
            return response.getBody();
        } catch(Exception e) {
            log.error("Exception occurred "+e.getMessage());
            return "Something went wrong";
        }
    }
}
