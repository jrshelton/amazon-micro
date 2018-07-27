package com.order.order.controller;

import com.order.order.model.Orders;
import com.order.order.repository.OrderLineRepository;
import com.order.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private OrderRepository orderRepository;
    //private OrderLineRepository orderLineRepository;

    public OrderController( OrderRepository orderRepository){
       // this.orderLineRepository = orderLineRepository;
        this.orderRepository = orderRepository;

    }

    @PostMapping("")
    public Orders createOrder(@Valid @RequestBody Orders order) {

        return orderRepository.save(order);
    }


    @RequestMapping("/all")
    public Iterable<Orders> findAll() {
        return orderRepository.findAll();
    }

    @RequestMapping("/{id}")
    public Optional<Orders> findById(@PathVariable("id") long id) {

        return orderRepository.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") long id) {
        orderRepository.deleteById(id);

    }

    @PutMapping("/{id}")
    public Orders editById(@PathVariable("id") long id, @RequestBody Orders order) {
        Optional<Orders> orderOptional = orderRepository.findById(id);
        if (!orderOptional.isPresent()) {
            return null;
        }
        order.setOrderId(id);
        return orderRepository.save(order);

    }



}
