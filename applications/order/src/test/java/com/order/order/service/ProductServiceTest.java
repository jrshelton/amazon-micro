package com.order.order.service;

import com.order.order.tempModels.Product;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import static org.junit.Assert.assertEquals;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class ProductServiceTest {

    @InjectMocks
    private ProductService productService;

    @Mock
    private RestTemplate restTemplate;

    @Before
    public void setUp(){
        productService = new ProductService(restTemplate);
    }

    @Test
    public void testGetProduct(){
        Product product = new Product();
        when(restTemplate.getForObject("http://product/products/" + 1, Product.class)).thenReturn(product);

        assertEquals(product, productService.getProduct((long)1));
    }




}
