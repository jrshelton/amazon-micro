package com.shipment.shipment.repository;

import com.shipment.shipment.model.Shipment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipmentRepository  extends CrudRepository<Shipment, Long> {
    //@Query("Select s FROM Shipment s WHERE account = :account ")
    //Iterable<Shipment> find(@Param("account") Account account);
}
