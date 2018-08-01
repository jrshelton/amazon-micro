package com.shipment.shipment.tempModels;



import java.util.Set;


public class Order {


    private long orderId;
    private String orderNumber;
    private String orderDate;
    private long account;



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




    public long getAccount() {
        return account;
    }

    public void setAccount(long account) {
        this.account = account;
    }



    public Set<OrderLine> getOrderLineItems() {
        return orderLineItems;
    }

    public void setOrderLineItems(Set<OrderLine> orderLineItems) {
        this.orderLineItems = orderLineItems;
    }



}

