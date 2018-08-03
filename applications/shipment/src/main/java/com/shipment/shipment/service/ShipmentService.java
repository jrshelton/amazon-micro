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
    private ProductService productService;
    private OrderLineService orderLineService;
    private OrderService orderService;
    private AddressService addressService;


    public ShipmentService(RestTemplate restTemplate, ShipmentRepository shipmentRepository, ProductService productService, OrderLineService orderLineService, OrderService orderService, AddressService addressService){
        this.restTemplate = restTemplate;
        this.shipmentRepository = shipmentRepository;
        this.productService = productService;
        this.orderLineService = orderLineService;

        this.orderService = orderService;
        this.addressService = addressService;
    }



    public List<ShipmentDisplay> getShipmentDisplay(long id){
        List<ShipmentDisplay> displays = new ArrayList();
        System.out.println((1));
        ArrayList<Shipment> shipments = (ArrayList)shipmentRepository.findAllByAccount(id);
        for(Shipment shipment : shipments){
            ShipmentDisplay shipmentDisplay = new ShipmentDisplay();
            if(shipment.getOrderLine().length>0) {
                OrderLine orderLine = orderLineService.getOrderLine(shipment.getOrderLine()[0]);

            //get order number
                if(orderLine.getOrderIds()!=0){
                    Order order = orderService.getOrder(orderLine.getOrderIds());
                    shipmentDisplay.setOrderNumber(order.getOrderNumber());
                }
            }

            shipmentDisplay.setShipmentDate(shipment.getShippedDate().toString());
            shipmentDisplay.setDeliveryDate(shipment.getDeliveryDate().toString());
            if(shipment.getShippingAddress()!=0) {
                shipmentDisplay.setShippingAddress(addressService.getShippingAddress(shipment.getShippingAddress()));
            }
            List<OrderLineDisplay> lineDisplays = new ArrayList<>();

            for(int i = 0; i<shipment.getOrderLine().length; i++) {
                OrderLine orderLine;
                if(shipment.getOrderLine()[i]!=0){
                    orderLine = orderLineService.getOrderLine(shipment.getOrderLine()[i]);
                }else{
                    orderLine = new OrderLine();
                }

                Product product;
                if(orderLine.getProduct() != 0) {
                    product = productService.getProduct(orderLine.getProduct());
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
