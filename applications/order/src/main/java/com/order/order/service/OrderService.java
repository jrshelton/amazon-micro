package com.order.order.service;

import com.order.order.model.Order;
import com.order.order.model.OrderLine;
import com.order.order.repository.OrderRepository;
import com.order.order.tempModels.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class OrderService {

    private RestTemplate restTemplate;
    private OrderRepository orderRepository;
    private ProductService productService;
    private AddressService addressService;
    private ShipmentService shipmentService;


    public OrderService(RestTemplate restTemplate, OrderRepository orderRepository, ProductService productService, AddressService addressService, ShipmentService shipmentService){
        this.restTemplate = restTemplate;
        this.orderRepository = orderRepository;
        this.productService = productService;
        this.addressService = addressService;
        this.shipmentService = shipmentService;
    }

    public  List<OrderDetails> getOrderDetails(long id) {
        ArrayList<Order> orders = (ArrayList)orderRepository.findAllByAccountOrderByOrderDate(id);
        System.out.println(orders.size());
        List<OrderDetails> orderDetails = new ArrayList<>();
        for(Order order : orders) {
            OrderDetails details = new OrderDetails();
            details.setOrderNumber(order.getOrderNumber());
            details.setShippingAddress(addressService.getAddress(order.getShippingAddress()));
            Set<LineItemDesplay> lineDisplays = new HashSet<>();
            double price = 0;
            for (OrderLine line : order.getOrderLineItems()) {
                Product product = productService.getProduct(line.getProduct());
                Shipment shipment = shipmentService.getShipment(line.getShipment());
                price += product.getPrice() * line.getQuantity();
                lineDisplays.add(new LineItemDesplay(product.getName(), line.getQuantity(), shipment));

            }
            details.setTotalPrice(price);
            details.setOrderLines(lineDisplays);
            orderDetails.add(details);
        }
        return orderDetails;
    }

}
