package com.order.order.service;

import com.order.order.service.AddressService;
import com.order.order.tempModels.Address;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import static org.junit.Assert.assertEquals;


import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class AddressServiceTest {

    @InjectMocks
    private AddressService addressService;

    @Mock
    private RestTemplate restTemplate;

    @Before
    public void setUp(){
        addressService = new AddressService(restTemplate);
    }
    @Test
    public void testGetAddress(){
        Address address = new Address();
        when(restTemplate.getForObject("http://account/accounts/address/" + 1, Address.class)).thenReturn(address);

        assertEquals(address, addressService.getAddress((long)1));
    }

}
