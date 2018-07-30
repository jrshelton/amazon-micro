package com.order.order.controller;

import com.order.order.model.Order;
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
        this.orderRepository = orderRepository;

    }
    @PostMapping("/random")
    public Order createRandomOrder() {
        Order order = new Order();
        order.setOrderDate("2018-06-05");
        order.setTotal(234);
        return orderRepository.save(order);
    }

    @PostMapping("")
    public Order createOrder(@Valid @RequestBody Order order) {

        return orderRepository.save(order);
    }


    @RequestMapping("")
    public Iterable<Order> findAll() {
        return orderRepository.findAll();
    }

    @RequestMapping("/{id}")
    public Optional<Order> findById(@PathVariable("id") long id) {

        return orderRepository.findById(id);
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


}
