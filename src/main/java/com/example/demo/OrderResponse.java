package com.example.demo;

import java.time.LocalDate;
import java.util.Date;

public class OrderResponse {
    private String    orderId;
    private Date orderDate;

    public OrderResponse() {
    }

    public OrderResponse(String orderId, Date orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
}
