package com.order.order.repository;

import com.order.order.model.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderLineRepository extends JpaRepository<OrderLine, Long> {
    OrderLine deleteByOrderLineIdAndOrder_OrderId(long id, long orderLineId);
    OrderLine findByOrderLineIdAndAndOrder_OrderId(long id, long orderLineId);
    //OrderLine findByOrderIdAndOrder_OrderId(long id, long orderLineId);
    Iterable<OrderLine> findAllByOrder_OrderId(long orderId);
    //deleteByAddressIdAndAccount_AccountId


    //List<Address> findAllByAccount(Account AccountId);
    //Address findByAddressIdAndAccount_AccountId(long addressId, long accountId);
    //Address deleteByAddressIdAndAccount_AccountId(long addressId, long accountId);
}
