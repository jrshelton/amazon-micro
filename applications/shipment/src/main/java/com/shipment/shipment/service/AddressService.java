package com.shipment.shipment.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.shipment.shipment.repository.ShipmentRepository;
import com.shipment.shipment.tempModels.Address;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AddressService {

    private RestTemplate restTemplate;


    public AddressService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;

    }
    @HystrixCommand(fallbackMethod = "getAddressFalLBack")
    public Address getShippingAddress(long id){
        return restTemplate.getForObject("http://account/accounts/address/" + id, Address.class);
    }

    public Address getAddressFalLBack(long id){
        return new Address();
    }
}
