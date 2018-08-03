package com.shipment.shipment.service;

import com.shipment.shipment.repository.ShipmentRepository;
import com.shipment.shipment.tempModels.Address;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AddressService {

    private RestTemplate restTemplate;
    private ShipmentRepository shipmentRepository;


    public AddressService(RestTemplate restTemplate, ShipmentRepository shipmentRepository) {


    }

    public Address getShippingAddress(long id){
        return restTemplate.getForObject("http://account/accounts/address/" + id, Address.class);
    }
}
