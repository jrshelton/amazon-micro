package com.account.account.controller;

import com.account.account.model.Account;
import com.account.account.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/account")
public class AccountController {

    private AccountRepository accountRepository;

    @Autowired
    public AccountController(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    @PostMapping("")
    public Account createAccount(@Valid @RequestBody Account account){

        return accountRepository.save(account);
    }

    @RequestMapping("/all")
    public Iterable<Account> findAll(){
        return accountRepository.findAll();
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
