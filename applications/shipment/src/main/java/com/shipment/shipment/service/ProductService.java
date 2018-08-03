package com.shipment.shipment.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.shipment.shipment.repository.ShipmentRepository;
import com.shipment.shipment.tempModels.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductService {

    private RestTemplate restTemplate;


    public ProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @HystrixCommand(fallbackMethod = "getProductFallBack")
    public Product getProduct(long id){
        return restTemplate.getForObject("http://product/products/" + id, Product.class);
    }

    public Product getProductFallBack(long id){
        return new Product();
    }
}
