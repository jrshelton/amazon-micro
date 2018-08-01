package com.shipment.shipment.tempModels;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;


public class OrderLine {



    long orderLineId;

    int quantity;
    double price;
    double totalPrice;

    long product;
    long shipment;


    private Order order;
    private long orderIds;

    public long getOrderIds() {
        return orderIds;
    }

    public void setOrderIds(long orderIds) {
        this.orderIds = orderIds;
    }

    public OrderLine(){}

    public long getShipment(){
        return this.shipment;

    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotalPrice() {
        return price * quantity;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public long getProduct() {
        return product;
    }

    public void setProduct(long product) {
        this.product = product;
    }



    public void setShipment(long shipment) {
        this.shipment = shipment;
    }

    public Order getOrder() {
        return this.order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }



    public long getOrderLineItemId() {
        return orderLineId;
    }

    public void setOrderLineItemId(long orderLineItemId) {
        this.orderLineId = orderLineItemId;
    }




}
