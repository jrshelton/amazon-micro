package com.account.account.controller;

import com.account.account.SecurityConfig;
import com.account.account.controller.AccountController;
import com.account.account.model.Account;
import com.account.account.repository.AccountRepository;

import com.account.account.repository.AddressRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
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
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {SecurityConfig.class})
public class AccountControllerTest {

    private MockMvc mvc;

    @Mock
    private AccountRepository accountRepository;
    @Mock
    private AddressRepository addressRepository;
    @InjectMocks
    private AccountController accountController;



    @Before
    public void setup() {
        accountController = new AccountController(accountRepository, addressRepository);
        MockitoAnnotations.initMocks(this);
        this.mvc = MockMvcBuilders.standaloneSetup(accountController).build();

    }


    @Test
    public void testControllerIsNotNull() {
        assertNotNull(accountRepository);
    }

    @Test
    public void testFindById() throws Exception {
        mvc.perform(get("/accounts/1")).andExpect(status().isOk());
    }

    @Test
    public void testFindAll() throws Exception {
        mvc.perform(get("/accounts/all")).andExpect(status().isOk());
    }

    @Test
    public void testCreateAccount() throws Exception {
        String json = "{ \"firstName\": \"Jack\"," +
                " \"lastName\": \"Shelton\"," +
                " \"emailAddress\": \"test@solstice.com\" }";

        mvc.perform(post("/accounts")
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(json))
                .andExpect(status().isOk());

    }

    @Test
    public void testGetAccounts() throws Exception {
        mvc.perform(get("/accounts/all"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void testUpdateAccount() throws Exception {
        when(accountRepository.save(any())).thenReturn(new Account());
        when(accountRepository.findById(anyLong())).thenReturn(java.util.Optional.of(new Account()));

        mvc.perform(put("/accounts/1"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void testDeleteAccount() throws Exception {
        mvc.perform(delete("/accounts/1"))
                .andExpect(status().isOk())
                .andDo(print());
    }
}
