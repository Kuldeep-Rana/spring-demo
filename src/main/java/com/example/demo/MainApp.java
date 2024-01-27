package com.example.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDate;
import java.util.Date;

public class MainApp {

    public static void main(String[] args) throws JsonProcessingException {
        Address address = new Address();
        User user = new User();
        user.setAddress(address);
        user.getAddress().hi();

        var order = new OrderRequest();order.setOrderDate(new Date());
        System.out.println(new ObjectMapper().writeValueAsString(order));

    }
}
