package com.shipment.shipment.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

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
    @JsonIgnore
    String _links;

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

    public long getShippingAddressAddress() {
        return ShippingAddress;
    }

    public void setShippingAddressAddress(long address) {
        this.ShippingAddress = address;
    }


    public long getShipmentId() {
        return shipmentId;
    }

    public void setShipmentId(long shipmentId) {
        this.shipmentId = shipmentId;
    }
}


