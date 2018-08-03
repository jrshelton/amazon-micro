package com.shipment.shipment.service;

import com.shipment.shipment.repository.ShipmentRepository;
import com.shipment.shipment.tempModels.Order;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    private RestTemplate restTemplate;

    public OrderService(RestTemplate restTemplate, ShipmentRepository shipmentRepository) {
        this.restTemplate = restTemplate;
    }

    public Order getOrder(long id) {
        return restTemplate.getForObject("http://order/orders/" + id, Order.class);
    }


}