package com.shipment.shipment.service;

import com.shipment.shipment.model.Shipment;
import com.shipment.shipment.repository.ShipmentRepository;
import com.shipment.shipment.tempModels.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShipmentService {

    private RestTemplate restTemplate;
    private ShipmentRepository shipmentRepository;

    public ShipmentService(RestTemplate restTemplate, ShipmentRepository shipmentRepository){
        this.restTemplate = restTemplate;
        this.shipmentRepository = shipmentRepository;
    }


    public OrderLine getOrderLine(long id){
        return restTemplate.getForObject("http://order/orders/lines/" + id, OrderLine.class);
    }

    public Product getProduct(long id){
        return restTemplate.getForObject("http://product/products/" + id, Product.class);
    }

    public Order getOrder(long id){
        return restTemplate.getForObject("http://order/orders/" + id, Order.class);
    }

    public List<Order> getOrderByAccountId(long id){
        return restTemplate.getForObject("http://order/orders?accountId=" + id, List.class);
    }

    public Address getShippingAddress(long id){
        return restTemplate.getForObject("http://account/accounts/address/" + id, Address.class);
    }

    public List<ShipmentDisplay> getShipmentDisplay(long id){
        List<ShipmentDisplay> displays = new ArrayList();
        System.out.println((1));
        ArrayList<Shipment> shipments = (ArrayList)shipmentRepository.findAllByAccount(id);
        for(Shipment shipment : shipments){
            ShipmentDisplay shipmentDisplay = new ShipmentDisplay();
            if(shipment.getOrderLine().length>0) {
                OrderLine orderLine = getOrderLine(shipment.getOrderLine()[0]);

            //get order number
                if(orderLine.getOrderIds()!=0){
                    Order order = getOrder(orderLine.getOrderIds());
                    shipmentDisplay.setOrderNumber(order.getOrderNumber());
                }
            }

            shipmentDisplay.setShipmentDate(shipment.getShippedDate().toString());
            shipmentDisplay.setDeliveryDate(shipment.getDeliveryDate().toString());
            if(shipment.getShippingAddress()!=0) {
                shipmentDisplay.setShippingAddress(getShippingAddress(shipment.getShippingAddress()));
            }
            List<OrderLineDisplay> lineDisplays = new ArrayList<>();

            for(int i = 0; i<shipment.getOrderLine().length; i++) {
                OrderLine orderLine;
                if(shipment.getOrderLine()[i]!=0){
                    orderLine = getOrderLine(shipment.getOrderLine()[i]);
                }else{
                    orderLine = new OrderLine();
                }

                Product product;
                if(orderLine.getProduct() != 0) {
                    product = getProduct(orderLine.getProduct());
                }else {
                    product = new Product();
                }

                lineDisplays.add(new OrderLineDisplay(product.getName(), orderLine.getQuantity()));

            }
            shipmentDisplay.setOrderLine(lineDisplays);
            displays.add(shipmentDisplay);
        }
        System.out.println((5));
        return displays;

    }
}
