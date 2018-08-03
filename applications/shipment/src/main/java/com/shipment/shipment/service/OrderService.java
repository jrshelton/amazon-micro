package com.shipment.shipment.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.utils.FallbackMethod;
import com.shipment.shipment.repository.ShipmentRepository;
import com.shipment.shipment.tempModels.Order;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    private RestTemplate restTemplate;

    public OrderService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @HystrixCommand(fallbackMethod = "getOrderFallBack")
    public Order getOrder(long id) {
        return restTemplate.getForObject("http://order/orders/" + id, Order.class);
    }

    public Order getOrderFallBack(long id){
        return new Order();
    }

}
