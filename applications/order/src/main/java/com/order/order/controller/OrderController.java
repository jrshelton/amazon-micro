package com.order.order.controller;

import com.order.order.model.Order;
import com.order.order.tempModels.*;
import com.order.order.repository.OrderRepository;
import com.order.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.*;

@RestController
@RequestMapping("/orders")
public class OrderController {


    private OrderRepository orderRepository;
    private OrderService orderService;



    public OrderController(OrderRepository orderRepository, OrderService orderService){
        this.orderRepository = orderRepository;
        this.orderService  = orderService;

    }


    @PostMapping("")
    public Order createOrder(@Valid @RequestBody Order order) {

        return orderRepository.save(order);
    }


    @RequestMapping("/all")
    public Iterable<Order> findAll() {
        return orderRepository.findAll();
    }


    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") long id) {
        orderRepository.deleteById(id);

    }

    @PutMapping("/{id}")
    public Order editById(@PathVariable("id") long id, @RequestBody Order order) {
        Optional<Order> orderOptional = orderRepository.findById(id);
        if (!orderOptional.isPresent()) {
            return null;
        }
        order.setOrderId(id);
        return orderRepository.save(order);

    }

    @GetMapping("")
    public Iterable<Order> getOrdersOfAccount(@RequestParam("accountId") long accountId){
        return orderRepository.findAllByAccountOrderByOrderDate(accountId);
    }

    @GetMapping("/{id}")
    public List<OrderDetails> getOrderDetails(@PathVariable("id") long id){

        return orderService.getOrderDetails(id );

    }

/*
    @RequestMapping("/shipments/{id}")
    public Shipment getShipment(@PathVariable("id")long id){
        return orderService.getShipment(id);
    }
    @RequestMapping("/products/{id}")
    public Product getProduct(@PathVariable("id")long id){
        return orderService.getProduct(id);
    }

    @RequestMapping("/address/{id}")
    public Address getAddress(@PathVariable("id")long id){
        return orderService.getAddress(id);
    }
    //@RequestMapping("/{id}")
    public Optional<Order> findById(@PathVariable("id") long id) {

        return orderRepository.findById(id);
    }

      @PostMapping("/random")
    public Order createRandomOrder() {
        Order order = new Order();
        order.setOrderDate("2018-06-05");
        order.setTotal(234);
        return orderRepository.save(order);
    }

*/




}
