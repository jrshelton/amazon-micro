package com.shipment.shipment.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.shipment.shipment.repository.ShipmentRepository;
import com.shipment.shipment.tempModels.OrderLine;
import com.shipment.shipment.tempModels.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderLineService {
    private RestTemplate restTemplate;

    public OrderLineService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @HystrixCommand(fallbackMethod = "getOrderLineFallBack")
    public OrderLine getOrderLine(long id){
        return restTemplate.getForObject("http://order/orders/lines/" + id, OrderLine.class);
    }

    public OrderLine getOrderLineFallBack(long id){
        return new OrderLine();
    }
}

