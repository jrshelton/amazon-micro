package com.account.account.model;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class AddressTest {

    @Test
    public void testAddress(){
        Address address = new Address();
        address.setAccount(new Account());
        address.setAddressId(1);
        address.setBuilding("building");
        address.setCountry("usa");
        address.setState("il");

        assertEquals(address.getAddressId(), 1);
        assertEquals(address.getBuilding(), "building");
        assertEquals(address.getCountry(), "usa");
        assertEquals(address.getState(), "il");

    }
}
