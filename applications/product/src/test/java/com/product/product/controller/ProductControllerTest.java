package com.product.product.controller;

import com.product.product.SecurityConfig;

import com.product.product.model.Product;
import com.product.product.repository.ProductRepository;
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
public class ProductControllerTest {

    private MockMvc mvc;

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductController productController;



    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        productController = new ProductController(productRepository);
        this.mvc = MockMvcBuilders.standaloneSetup(productController).build();
    }

    @Test
    public void testFindById() throws Exception {
        //Mockito.when(productRepository.findById(any())).thenReturn(java.util.Optional.of(new Product()));
        mvc.perform(get("/products/1")).andExpect(status().isOk());
    }

    @Test
    public void testFindAll() throws Exception {
        mvc.perform(get("/products/all")).andExpect((status().isOk()));
    }

    @Test
    public void testCreateProduct() throws Exception {
        String json = "{ " +
                "\"name\": \"test\"," +
                " \"description\": \"test\", " +
                "\"image\": \"test\"," +
                "\"price\": 10 "+
                 "}";
        mvc.perform(post("/products").contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteProduct() throws Exception {
        mvc.perform(delete("/products/1")).andExpect((status().isOk()));
    }

    @Test
    public void testEditProduct() throws Exception {
        String json = "{ " +
                "\"name\": \"test\"," +
                " \"description\": \"test\", " +
                "\"image\": \"test\"," +
                "\"price\": 10 "+
                "}";
        mvc.perform(put("/products/1").contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect((status().isOk()));

    }

}
