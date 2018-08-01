package com.account.account.controller;

import com.account.account.model.Account;
import com.account.account.model.Address;
import com.account.account.repository.AccountRepository;
import com.account.account.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private AccountRepository accountRepository;
    private AddressRepository addressRepository;


    public AccountController(AccountRepository accountRepository, AddressRepository addressRepository){
        this.accountRepository = accountRepository;
        this.addressRepository = addressRepository;
    }
    //only for testing
    //todo: delete this endpoint
   /* @PostMapping("/create")
    public long create(){
        Address add =  addressRepository.save(new Address("Forst", "1109", "il", 60091, "usa"));
        Account save = accountRepository.save(new Account("Jack", "Shelton", "jsehlton@solsic.com", add));
        return save.getAccountId();
    }
*/
    @RequestMapping("/all")
    public Iterable<Account> findAll(){
        return accountRepository.findAll();
    }

    @PostMapping("")
    public Account createAccount(@Valid @RequestBody Account account){

        return accountRepository.save(account);
    }

    @RequestMapping("/{id}")
    public Optional<Account> findByID(@PathVariable("id") long id){
        return accountRepository.findById(id);
    }



    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") long id){
        accountRepository.deleteById(id);

    }

}
