package com.shipment.shipment.service;

import com.shipment.shipment.tempModels.Address;
import com.shipment.shipment.tempModels.Order;
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
public class OrderServiceTest {
    @InjectMocks
    private OrderService orderService;

    @Mock
    private RestTemplate restTemplate;

    @Before
    public void setUp(){
        orderService = new OrderService(restTemplate);
    }
    @Test
    public void testGetAddress(){
        Order order = new Order();
        when(restTemplate.getForObject("http://order/orders/" + 1, Order.class)).thenReturn(order);

        assertEquals(order, orderService.getOrder((long)1));
    }
}

