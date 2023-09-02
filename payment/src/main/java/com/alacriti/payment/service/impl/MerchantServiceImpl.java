package com.alacriti.payment.service.impl;

import com.alacriti.payment.entities.Merchant;
import com.alacriti.payment.repository.MerchantRepository;
import com.alacriti.payment.service.MerchantSerivice;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class MerchantServiceImpl implements MerchantSerivice {

    @Autowired
    private MerchantRepository merchantRepository;

    @Override
    public String registerMerchant(Merchant merchant) {
        try {
            merchantRepository.save(merchant);
            return "Merchant registered Successfully";
        } catch(Exception e) {
            log.error("Exception occurred "+e.getMessage());
            return "Something went wrong";
        }
    }
}
