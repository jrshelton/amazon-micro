package com.order.order.service;
import com.order.order.model.Order;
import com.order.order.repository.OrderRepository;
import com.order.order.tempModels.Address;
import com.order.order.tempModels.OrderDetails;
import com.order.order.tempModels.Product;
import com.order.order.tempModels.Shipment;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

//@RunWith(SpringRunner.class)
public class OrderServiceTest {

    @Mock
    private RestTemplate restTemplate;
    @Mock
    private OrderRepository orderRepository;
    @InjectMocks
    private OrderService orderService;
    @Mock
    private ProductService productService;
    @Mock
    private AddressService addressService;
    @Mock
    private ShipmentService shipmentService;


    @Before
    public void setUp(){
        orderService = new OrderService( restTemplate, orderRepository, productService, addressService, shipmentService);
    }





    public void testGetOrderDetails(){
        when(addressService.getAddress(any())).thenReturn(new Address());
        when(productService.getProduct(any())).thenReturn(new Product());
        when(shipmentService.getShipment(any())).thenReturn(new Shipment());
        when(orderRepository.findById(any())).thenReturn(java.util.Optional.of(new Order()));
        OrderDetails order = new OrderDetails();
        assertEquals(order.getClass(), orderService.getOrderDetails(1).getClass());

    }

}
