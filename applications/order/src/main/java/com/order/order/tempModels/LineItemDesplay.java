package com.order.order.tempModels;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class LineItemDesplay {
    private String ProductName;
    private int quantity;

    @JsonIgnoreProperties({"shipmentId", "account"})
    private Shipment shipment;

    public LineItemDesplay(String productName, int quantity, Shipment shipment) {
        this.ProductName = productName;
        this.quantity = quantity;
        this.shipment = shipment;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Shipment getShipment() {
        return shipment;
    }

    public void setShipment(Shipment shipment) {
        this.shipment = shipment;
    }
}
