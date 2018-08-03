package com.shipment.shipment.tempModels;

import com.shipment.shipment.tempModels.OrderLine;

import javax.persistence.*;
import java.util.Set;


public class Order {


    private long orderId;
    private String orderNumber;
    private String orderDate;
    private double total;
    private long account;
    private long shippingAddress;


    private Set<OrderLine> orderLineItems;


    public Order(){}

    public void addLineItem(OrderLine item){
        orderLineItems.add(item);
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long id) {
        this.orderId = id;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public double getTotal() {
        double tot = 0;
        if(orderLineItems == null){
            this.total = 0;
            return 0;
        }
        for(OrderLine item: orderLineItems){
            tot += item.getTotalPrice();
        }
        this.total = tot;
        return this.total;
    }

    public void setTotal(double total) {

        this.total = total;
    }

    public long getAccount() {
        return account;
    }

    public void setAccount(long account) {
        this.account = account;
    }

    public long getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(long shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public Set<OrderLine> getOrderLineItems() {
        return orderLineItems;
    }

    public void setOrderLineItems(Set<OrderLine> orderLineItems) {
        this.orderLineItems = orderLineItems;
    }



}

