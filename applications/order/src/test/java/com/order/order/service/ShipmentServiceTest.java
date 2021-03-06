package com.order.order.service;

import com.order.order.tempModels.Shipment;
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
public class ShipmentServiceTest {

    @InjectMocks
    private ShipmentService shipmentService;

    @Mock
    private RestTemplate restTemplate;

    @Before
    public void setUp(){
        shipmentService = new ShipmentService(restTemplate);
    }

    @Test
    public void testGetShipment(){
        Shipment shipment = new Shipment();
        when(restTemplate.getForObject("http://shipment/shipments/" + 1, Shipment.class)).thenReturn(shipment);

        assertEquals(shipment, shipmentService.getShipment((long)1));
    }




}