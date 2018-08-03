package com.shipment.shipment.service;

import com.shipment.shipment.tempModels.OrderLine;
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
public class OrderLineServiceTest {
    @InjectMocks
    private OrderLineService orderLineService;

    @Mock
    private RestTemplate restTemplate;

    @Before
    public void setUp() {
        orderLineService = new OrderLineService(restTemplate);
    }

    @Test
    public void testGetOrderLine() {
        OrderLine orderLine = new OrderLine();
        when(restTemplate.getForObject("http://order/orders/lines/" + 1, OrderLine.class)).thenReturn(orderLine);

        assertEquals(orderLine, orderLineService.getOrderLine((long) 1));
    }
}
