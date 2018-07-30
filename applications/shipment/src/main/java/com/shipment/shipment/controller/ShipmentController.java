package com.shipment.shipment.controller;


import com.shipment.shipment.model.Shipment;
import com.shipment.shipment.repository.ShipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/shipment")
public class ShipmentController {/*

    private ShipmentRepository shipmentRepository;

    public ShipmentController(ShipmentRepository shipmentRepository){
        this.shipmentRepository = shipmentRepository;
    }

    @PostMapping("/create")
    public Shipment createShipment(@Valid @RequestBody Shipment shipment) {

        return shipmentRepository.save(shipment);
    }

    @RequestMapping("/all")
    public Iterable<Shipment> findAll() {
        return shipmentRepository.findAll();
    }

    @RequestMapping("/{id}")
    public Optional<Shipment> findById(@PathVariable("id") long id) {

        return shipmentRepository.findById(id);
    }

    @DeleteMapping("delete/{id}")
    public void deleteById(@PathVariable("id") long id) {
        shipmentRepository.deleteById(id);

    }

    @PutMapping("edit/{id}")
    public Shipment editById(@PathVariable("id") long id, @RequestBody Shipment shipment) {
        Optional<Shipment> shipmentOptional = shipmentRepository.findById(id);
        if (!shipmentOptional.isPresent()) {
            return null;
        }
        shipment.setShipmentId(id);
        return shipmentRepository.save(shipment);

    }
    */
}
