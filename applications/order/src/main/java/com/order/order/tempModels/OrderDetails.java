package com.order.order.tempModels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Set;

public class OrderDetails {
    private String orderNumber;
    private Address shippingAddress;
    private double totalPrice;
    //@JsonIgnoreProperties({"orderLineId", "price", "totalPrice", "shipment", "description", "image", "price"})
    private Set<LineItemDesplay> orderLines;




    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderDetails) {
        this.orderNumber = orderDetails;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Set<LineItemDesplay> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(Set<LineItemDesplay> orderLines) {
        this.orderLines = orderLines;
    }


}
