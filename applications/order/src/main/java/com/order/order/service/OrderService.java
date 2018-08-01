package com.order.order.service;

import com.order.order.model.Order;
import com.order.order.model.OrderLine;
import com.order.order.repository.OrderRepository;
import com.order.order.tempModels.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashSet;
import java.util.Set;

@Service
public class OrderService {

    private RestTemplate restTemplate;
    private OrderRepository orderRepository;

    public OrderService(RestTemplate restTemplate, OrderRepository orderRepository){
        this.restTemplate = restTemplate;
        this.orderRepository = orderRepository;
    }

    public  OrderDetails getOrderDetails(long id) {
        Order order = orderRepository.findById(id).get();
        OrderDetails details = new OrderDetails();
        details.setOrderNumber(order.getOrderNumber());
        details.setShippingAddress(getAddress(order.getShippingAddress()));
        Set<LineItemDesplay> lineDisplays = new HashSet<>();
        double price = 0;
        for(OrderLine line: order.getOrderLineItems()){
            Product product = getProduct(line.getProduct());
            Shipment shipment = getShipment(line.getShipment());
            price+= product.getPrice()*line.getQuantity();
            lineDisplays.add(new LineItemDesplay(product.getName(), line.getQuantity(), shipment));

        }
        details.setTotalPrice(price);
        details.setOrderLines(lineDisplays);
        return details;
    }



    public Shipment getShipment(long id){
        return restTemplate.getForObject("http://shipment/shipments/" + id, Shipment.class);
    }

    public Product getProduct(long id){
        return restTemplate.getForObject("http://product/products/" + id, Product.class);
    }

    public Address getAddress(long id){
        return restTemplate.getForObject("http://account/accounts/address/" + id, Address.class);
    }






}
