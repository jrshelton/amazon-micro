package com.order.order.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.order.order.tempModels.Shipment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ShipmentService {

    private RestTemplate restTemplate;

    public ShipmentService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @HystrixCommand(fallbackMethod = "getShipmentFallBack")
    public Shipment getShipment(long id){
        return restTemplate.getForObject("http://shipment/shipments/" + id, Shipment.class);
    }

    public Shipment getShipmentFallBack(long id){
        return new Shipment();
    }
}
