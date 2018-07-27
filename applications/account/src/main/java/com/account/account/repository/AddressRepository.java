package com.account.account.repository;

import com.account.account.model.Account;
import com.account.account.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface AddressRepository extends JpaRepository<Address, Long> {
    List<Address> findAllByAccount(Account AccountId);
    Address findByAddressIdAndAccount_AccountId(long addressId, long accountId);
    Address deleteByAddressIdAndAccount_AccountId(long addressId, long accountId);


}