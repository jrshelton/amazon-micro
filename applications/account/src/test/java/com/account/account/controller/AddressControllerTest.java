package com.account.account.controller;



import com.account.account.SecurityConfig;
import com.account.account.model.Account;
import com.account.account.model.Address;
import com.account.account.repository.AccountRepository;
import com.account.account.repository.AddressRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {SecurityConfig.class})
public class AddressControllerTest {


    private MockMvc mvc;

    @Mock
    private AddressRepository addressRepository;

    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private AddressController addressController;



    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        addressController = new AddressController(addressRepository, accountRepository);
        this.mvc = MockMvcBuilders.standaloneSetup(addressController).build();

    }

    @Test
    public void testCreateAddress() throws Exception {
        String json = "{ " +
                "\"street\": \"stret\"," +
                " \"building\": \"building\", " +
                "\"city\": \"wilmette\"," +
                "\"state\": \"il\"," +
                "\"zip\": 60091," +
                "\"country\": \"US of A\"" +
                " }";
        when(accountRepository.findById(anyLong())).thenReturn(java.util.Optional.of(new Account()));
        mvc.perform(post("/accounts/1/address")
                .contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isOk());
    }
    @Test
    public void testFindAll() throws Exception {
        when(accountRepository.findById(anyLong())).thenReturn(java.util.Optional.of(new Account()));
        mvc.perform(get("/accounts/1/address")).andExpect(status().isOk());
    }

    @Test
    public void testFindById() throws Exception {
        when(accountRepository.findById(anyLong())).thenReturn(java.util.Optional.of(new Account()));
        mvc.perform(get("/accounts/1/address/2")).andExpect(status().isOk());
    }
    @Test
    public void testControllerIsNotNull() {
        assertNotNull(addressController);
    }



    @Test
    public void testGetAddress() throws Exception {
        when(accountRepository.findById(anyLong())).thenReturn(java.util.Optional.of(new Account()));
        mvc.perform(get("/accounts/1/address"))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteAddress() throws Exception {
        when(accountRepository.findById(anyLong())).thenReturn(java.util.Optional.of(new Account()));

        mvc.perform(delete("/accounts/1/address/1"))
                .andExpect(status().isOk());
    }
}
