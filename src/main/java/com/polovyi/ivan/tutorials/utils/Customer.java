package com.polovyi.ivan.tutorials.utils;

import java.time.LocalDate;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Customer {

    private Integer id;
    private String name;
    private String phoneNumber;
    private CustomerType type;
    private Boolean isActive;
    private Set<String> paymentMethods;
    private Address address;
    private Long purchaseQty;
    private LocalDate createdAt;

    @Data
    @AllArgsConstructor
    public static class Address {

        private String city;
        private String state;
    }


    public enum CustomerType {
        BUSINESS,
        INDIVIDUAL
    }

}
