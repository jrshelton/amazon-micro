package com.order.order.controller;


import com.order.order.SecurityConfig;
import com.order.order.model.Order;
import com.order.order.repository.OrderLineRepository;
import com.order.order.repository.OrderRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
@ContextConfiguration(classes = {SecurityConfig.class})
public class OrderLineControllerTest {

    private MockMvc mvc;

    @Mock
    private OrderLineRepository orderLineRepository;

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderLineController orderLineController;



    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        orderLineController = new OrderLineController(orderLineRepository, orderRepository);
        this.mvc = MockMvcBuilders.standaloneSetup(orderLineController).build();
    }

    @Test
    public void testFindById() throws Exception {
        Mockito.when(orderRepository.findById(any())).thenReturn(java.util.Optional.of(new Order()));
        mvc.perform(get("/orders/1/lines/1")).andExpect(status().isOk());
    }

    @Test
    public void testFindAll() throws Exception {
        Mockito.when(orderRepository.findById(any())).thenReturn(java.util.Optional.of(new Order()));
        mvc.perform(get("/orders/1/lines")).andExpect((status().isOk()));
    }

    @Test
    public void testCreateProduct() throws Exception {
        String json = "{ " +
                "\"quantity\": 4," +
                " \"price\": 10.99 " +
                "}";
        Mockito.when(orderRepository.findById(any())).thenReturn(java.util.Optional.of(new Order()));
        mvc.perform(post("/orders/1/lines").contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteProduct() throws Exception {
        Mockito.when(orderRepository.findById(any())).thenReturn(java.util.Optional.of(new Order()));
        mvc.perform(delete("/orders/1/lines")).andExpect((status().isOk()));
    }

    @Test
    public void testEditProduct() throws Exception {
        String json = "{ " +
                "\"quantity\": 4," +
                " \"price\": 10.99 " +
                "}";
        Mockito.when(orderRepository.findById(any())).thenReturn(java.util.Optional.of(new Order()));
        mvc.perform(put("/orders/1/lines/1").contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect((status().isOk()));

    }

}



