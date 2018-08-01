package com.order.order.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "order_line_item")
public class OrderLine {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "order_line_item_id")
    long orderLineId;

    int quantity;
    double price;
    double totalPrice;

    long product;
    long shipment;
    private long orderIds;

    @ManyToOne
    @JoinColumn(name = "order_id")
    @JsonBackReference
    private Order order;

    public OrderLine(){}

    public long getShipment(){
        return this.shipment;

    }
    public void setOrderIds(long id){
        order.getOrderId();
    }
    public long getOrderIds(){
        return order.getOrderId();
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
