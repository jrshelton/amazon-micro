package com.shipment.shipment.tempModels;

public class OrderLineDisplay {
    private String ProductName;
    private int Quantitiy;

    public OrderLineDisplay(String productName, int quantitiy) {
        ProductName = productName;
        Quantitiy = quantitiy;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public int getQuantitiy() {
        return Quantitiy;
    }

    public void setQuantitiy(int quantitiy) {
        Quantitiy = quantitiy;
    }
}
