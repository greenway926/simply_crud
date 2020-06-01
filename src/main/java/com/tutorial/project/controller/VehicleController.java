package com.tutorial.project.controller;

import com.tutorial.project.model.Vehicle;
import com.tutorial.project.repo.VehicleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VehicleController {

    @Autowired
    VehicleRepo vehicleRepo;

    @RequestMapping(value = "/inputVehicle")
    public String inputVehicle(@RequestParam String brand, String type, String plateNumber, int year){
        Vehicle vehicle = new Vehicle(brand, type, plateNumber, year);
        vehicleRepo.save(vehicle);
        return "vehicle berhasil diinput";
    }
}
