package com.account.account.model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class AccountTest {

    @Test
    public void testAccount(){
        Account account = new Account();
        account.setAccountId(1);
        account.setEmailAddress("j2518966@gmail.com");
        account.setFirstName("Jack");
        account.setLastName("Shelton");
        account.setAddress(new ArrayList<Address>());

        String email = "j2518966@gmail.com";
        assertEquals(email, account.getEmailAddress());

        String first = "Jack";
        String last = "Shelton";
        assertEquals(account.getFirstName(), first);
        assertEquals(account.getLastName(), last);
    }
}
