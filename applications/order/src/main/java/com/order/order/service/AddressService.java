package com.order.order.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.order.order.tempModels.Address;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AddressService {
    private RestTemplate restTemplate;

    public AddressService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @HystrixCommand(fallbackMethod = "getAddressFallBack")
    public Address getAddress(long id){
        return restTemplate.getForObject("http://account/accounts/address/" + id, Address.class);
    }

    public Address getAddressFallBack(long id){
        return new Address();
    }


}
