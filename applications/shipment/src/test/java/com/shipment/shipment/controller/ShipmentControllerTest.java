package com.shipment.shipment.controller;

import com.shipment.shipment.SecurityConfig;
import com.shipment.shipment.repository.ShipmentRepository;
import com.shipment.shipment.service.ShipmentService;
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
public class ShipmentControllerTest {

    private MockMvc mvc;

    @Mock
    private ShipmentRepository shipmentRepository;
    @Mock
    private ShipmentService shipmentService;

    @InjectMocks
    private ShipmentController shipmentController;



    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        shipmentController = new ShipmentController(shipmentRepository, shipmentService);
        this.mvc = MockMvcBuilders.standaloneSetup(shipmentController).build();
    }

    @Test
    public void testFindById() throws Exception {
        //Mockito.when(shipmentRepository.findById(any())).thenReturn(java.util.Optional.of(new Shipment()));
        mvc.perform(get("/shipments/1")).andExpect(status().isOk());
    }

    @Test
    public void testFindAll() throws Exception {
        mvc.perform(get("/shipments/")).andExpect((status().isOk()));
    }

    @Test
    public void testCreateShipment() throws Exception {
        String json =  "{ " +
                "\"shippedDate\": \"2019-02-04\"," +
                " \"deliveryDate\": \"2018-08-02\", " +
                "\"account\": 3," +
                "\"ShippingAddress\": 10 "+
                "}";
        mvc.perform(post("/shipments").contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteShipment() throws Exception {
        mvc.perform(delete("/shipments/1")).andExpect((status().isOk()));
    }

    @Test
    public void testEditShipment() throws Exception {
        String json = "{ " +
                "\"shippedDate\": \"2019-02-04\"," +
                " \"deliveryDate\": \"2018-08-02\", " +
                "\"account\": 3," +
                "\"ShippingAddress\": 10 "+
                "}";

        mvc.perform(put("/shipments/1").contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect((status().isOk()));

    }

}
