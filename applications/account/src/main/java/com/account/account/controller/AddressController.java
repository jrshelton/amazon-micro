package com.account.account.controller;


import com.account.account.model.Address;
import com.account.account.repository.AccountRepository;
import com.account.account.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/accounts")
public class AddressController {

    AccountRepository accountRepository;

    AddressRepository addressRepository;



    @Autowired
    public AddressController(AddressRepository addressRepository, AccountRepository accountRepository){
        this.addressRepository = addressRepository;
        this.accountRepository = accountRepository;
    }


    @PostMapping("/{accountId}/address")
    public Address createAddress(@PathVariable("accountId") long accountId, @RequestBody Address address){
        address.setAccount(accountRepository.findById(accountId).get());
        return addressRepository.save(address);
    }

    @RequestMapping("/{accountId}/address")
    public Iterable<Address> findAll(@PathVariable("accountId") long accountId){
        return addressRepository.findAllByAccount(accountRepository.findById(accountId).get());
    }

    @RequestMapping("/{accountId}/address/{id}")
    public Address findByID(@PathVariable("accountId") long accountId, @PathVariable("id") long id){
        return addressRepository.findByAddressIdAndAccount_AccountId(id, accountId);
    }



    @DeleteMapping("/{accountId}/address/{id}")
    public void deleteById(@PathVariable("accountId") long accountId,@PathVariable("id") long id){
        addressRepository.deleteByAddressIdAndAccount_AccountId(id, accountId);

    }


}
