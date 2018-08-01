package com.order.order.tempModels;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;


public class Shipment {

    long shipmentId;
    Date shippedDate;
    Date deliveryDate;

    long account;
    long ShippingAddress;


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


