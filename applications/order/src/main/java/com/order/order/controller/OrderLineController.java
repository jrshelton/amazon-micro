package com.order.order.controller;

import com.order.order.model.Orders;
import com.order.order.model.OrderLine;
import com.order.order.repository.OrderLineRepository;
import com.order.order.repository.OrderRepository;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.ws.rs.Path;
import java.util.Optional;


@RestController
@RequestMapping("/orders")
public class OrderLineController {

    private OrderLineRepository orderLineRepository;
    private OrderRepository orderRepository;


    public OrderLineController(OrderLineRepository orderLineRepository, OrderRepository orderRepository) {
        this.orderLineRepository = orderLineRepository;
        this.orderRepository = orderRepository;
    }

    @PostMapping("/{orderId}/lines")
    public OrderLine createOrderLine(@PathVariable("orderId") long orderId, @RequestBody OrderLine orderLine){
        orderLine.setOrder(orderRepository.findById(orderId).get());
        return orderLineRepository.save(orderLine);
    }

    @RequestMapping("/{orderId}/lines/all")
    public Iterable<OrderLine> findAll(@PathVariable("orderId") long orderId) {
        return orderLineRepository.findAllByOrder_OrderId(orderId);
    }

    @RequestMapping("/{orderId}/lines/{id}")
    public OrderLine findById(@PathVariable("orderId") long orderId,@PathVariable("id") long id) {

        return orderLineRepository.findByOrderLineIdAndAndOrder_OrderId(id, orderId);
    }

    @DeleteMapping("/{orderId}/lines/{id}")
    public void deleteById(@PathVariable("orderId") long orderId, @PathVariable("id") long id) {
        orderLineRepository.deleteByOrderLineIdAndOrder_OrderId(id, orderId);

    }
/*
    @PutMapping("/{orderId}/lines/{id}")
    public OrderLine editById(@PathVariable("id") long id, @RequestBody OrderLine orderLineItem) {
        Optional<OrderLine> orderLineItemOptional = orderLineRepository.findById(id);
        if (!orderLineItemOptional.isPresent()) {
            return null;
        }
        orderLineItem.setOrderLineItemId(id);
        return orderLineRepository.save(orderLineItem);

    }*/
}
