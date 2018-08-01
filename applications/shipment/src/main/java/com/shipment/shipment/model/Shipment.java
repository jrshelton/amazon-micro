package com.shipment.shipment.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Shipment {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "shipment_id")
    long shipmentId;
    Date shippedDate;
    Date deliveryDate;
    long account;
    long ShippingAddress;
    long[] orderLine;

    public long getShippingAddress() {
        return ShippingAddress;
    }

    public void setShippingAddress(long shippingAddress) {
        ShippingAddress = shippingAddress;
    }

    public long[] getOrderLine() {
        return orderLine;
    }

    public void setOrderLine(long[] orderLine) {
        this.orderLine = orderLine;
    }

/*
    public void addLineItems(long item) {
        orderLineItems.add(item);
    }
*/


    public Shipment(){}
    public Date getShippedDate() {
        return shippedDate;
    }

    public void setShippedDate(Date shippedDate) {
        this.shippedDate = shippedDate;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }


    public long getAccount() {
        return account;
    }

    public void setAccount(long account) {
        this.account = account;
    }



    public long getShipmentId() {
        return shipmentId;
    }

    public void setShipmentId(long shipmentId) {
        this.shipmentId = shipmentId;
    }
}


