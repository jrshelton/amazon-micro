package com.order.order.controller;


import com.order.order.SecurityConfig;
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
    public class OrderControllerTest {

        private MockMvc mvc;

        @Mock
        private OrderRepository orderRepositoy;

        @InjectMocks
        private OrderController orderController;



        @Before
        public void setup() {
            MockitoAnnotations.initMocks(this);
            orderController = new OrderController(orderRepositoy);
            this.mvc = MockMvcBuilders.standaloneSetup(orderController).build();
        }

        @Test
        public void testFindById() throws Exception {
            //Mockito.when(productRepository.findById(any())).thenReturn(java.util.Optional.of(new Product()));
            mvc.perform(get("/orders/1")).andExpect(status().isOk());
        }

        @Test
        public void testFindAll() throws Exception {
            mvc.perform(get("/orders")).andExpect((status().isOk()));
        }

        @Test
        public void testCreateProduct() throws Exception {
            String json = "{ " +
                    "\"orderNumber\": \"test\"," +
                    " \"orderDate\": \"test\" " +
                    "}";
            mvc.perform(post("/orders").contentType(MediaType.APPLICATION_JSON).content(json))
                    .andExpect(status().isOk());
        }

        @Test
        public void testDeleteProduct() throws Exception {
            mvc.perform(delete("/orders/1")).andExpect((status().isOk()));
        }

        @Test
        public void testEditProduct() throws Exception {
            String json = "{ " +
                    "\"orderNumber\": \"test\"," +
                    " \"orderDate\": \"test\" " +
                    "}";

            mvc.perform(put("/orders/1").contentType(MediaType.APPLICATION_JSON).content(json))
                    .andExpect((status().isOk()));

        }

    }


