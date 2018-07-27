package com.account.account.repository;

import com.account.account.model.Account;
import com.account.account.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface AccountRepository extends JpaRepository<Account, Long> {

}
