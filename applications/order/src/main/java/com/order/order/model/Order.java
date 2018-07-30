package com.order.order.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @Column(name="order_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long orderId;
    private String orderNumber;
    private String orderDate;
    private double total;
    private long account;
    private long shippingAddress;

    @OneToMany
    @JoinColumn(name = "order_id")
    private Set<OrderLine> orderLineItems;

    public Order(String orderNumber, String orderDate) {
        this.orderNumber = orderNumber;
        this.orderDate = orderDate;
        this.shippingAddress = shippingAddress;
    }
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

