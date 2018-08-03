package com.shipment.shipment.service;

import com.shipment.shipment.repository.ShipmentRepository;
import com.shipment.shipment.tempModels.OrderLine;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderLineService {
    private RestTemplate restTemplate;

    public OrderLineService(RestTemplate restTemplate, ShipmentRepository shipmentRepository) {
        this.restTemplate = restTemplate;
    }

    public OrderLine getOrderLine(long id){
        return restTemplate.getForObject("http://order/orders/lines/" + id, OrderLine.class);
    }
}
