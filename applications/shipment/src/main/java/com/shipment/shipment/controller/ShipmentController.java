package com.shipment.shipment.controller;


import com.shipment.shipment.model.Shipment;
import com.shipment.shipment.repository.ShipmentRepository;
import com.shipment.shipment.service.ShipmentService;
import com.shipment.shipment.tempModels.*;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/shipments")
public class ShipmentController {
    private ShipmentRepository shipmentRepository;
    private ShipmentService shipmentService;

    public ShipmentController(ShipmentRepository shipmentRepository, ShipmentService shipmentService){
        this.shipmentRepository = shipmentRepository;
        this.shipmentService = shipmentService;
    }

    @PostMapping("")
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

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") long id)
    {
        shipmentRepository.deleteById(id);
    }
    @PutMapping("/{id}")
    public Shipment editById(@PathVariable("id") long id, @RequestBody Shipment shipment) {
        Optional<Shipment> shipmentOptional = shipmentRepository.findById(id);
        if (!shipmentOptional.isPresent()) {
            return null;
        }
        shipment.setShipmentId(id);
        return shipmentRepository.save(shipment);
    }

    @GetMapping()
    public List<ShipmentDisplay> showShipmentDisplay(@RequestParam("accountId")long id){
        return shipmentService.getShipmentDisplay(id);
    }

}