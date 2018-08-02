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

@RunWith(SpringRunner.class)
public class OrderServiceTest {

    @Mock
    private RestTemplate restTemplate;
    @Mock
    private OrderRepository orderRepository;
    @InjectMocks
    private OrderService orderService;

    @Before
    public void setUp(){
        orderService = new OrderService( restTemplate, orderRepository, productService, addressService, shipmentService);
    }

    @Test
    public void testGetShipment(){
        Shipment shipment = new Shipment();
        when(restTemplate.getForObject("http://shipment/shipments/" + 1, Shipment.class)).thenReturn(shipment);

        assertEquals(shipment, orderService.getShipment((long)1));

    }

    @Test
    public void testGetProduct(){
        Product product = new Product();
        when(restTemplate.getForObject("http://product/products/" + 1, Product.class)).thenReturn(product);

        assertEquals(product, orderService.getProduct((long)1));
    }

    @Test
    public void testGetAddress(){
        Address address = new Address();
        when(restTemplate.getForObject("http://account/accounts/address/" + 1, Address.class)).thenReturn(address);

        assertEquals(address, orderService.getAddress((long)1));
    }

    public void testGetOrderDetails(){
        when(orderService.getAddress(any())).thenReturn(new Address());
        when(orderService.getProduct(any())).thenReturn(new Product());
        when(orderService.getShipment(any())).thenReturn(new Shipment());
        when(orderRepository.findById(any())).thenReturn(java.util.Optional.of(new Order()));
        OrderDetails order = new OrderDetails();
        assertEquals(order.getClass(), orderService.getOrderDetails(1).getClass());

    }

}
