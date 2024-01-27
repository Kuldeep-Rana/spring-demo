package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class User {
    private Address address;
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
}
