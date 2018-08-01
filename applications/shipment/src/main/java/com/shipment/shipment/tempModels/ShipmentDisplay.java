package com.shipment.shipment.tempModels;

import java.util.Date;
import java.util.List;

public class ShipmentDisplay {
    private String orderNumber;
    private String shipmentDate;
    private String deliveryDate;
    private List<OrderLineDisplay> orderLine;
    private Address shippingAddress;



    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getShipmentDate() {
        return shipmentDate;
    }

    public void setShipmentDate(String shipmentDate) {
        this.shipmentDate = shipmentDate;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public List<OrderLineDisplay> getOrderLine() {
        return orderLine;
    }

    public void setOrderLine(List<OrderLineDisplay> orderLine) {
        this.orderLine = orderLine;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }
}
