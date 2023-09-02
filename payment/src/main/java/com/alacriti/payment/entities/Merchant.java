package com.alacriti.payment.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "merchant")
public class Merchant {

    @Id
    private String merchantId;
    private String name;
    private String email;
    private String businessType;
    private String address;
    private String phone;
}
