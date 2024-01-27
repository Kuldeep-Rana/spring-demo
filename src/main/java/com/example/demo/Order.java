package com.example.demo;

import java.util.UUID;
public class Order {
    private String orderID= UUID.randomUUID().toString();
    private double cost = 1232.899;

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
