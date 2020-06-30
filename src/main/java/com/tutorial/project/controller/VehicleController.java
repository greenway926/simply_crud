package com.tutorial.project.controller;

import com.tutorial.project.model.Vehicle;
import com.tutorial.project.repo.VehicleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class VehicleController {

    @Autowired
    VehicleRepo vehicleRepo;

    @RequestMapping(value = "/inputVehicle")
    public String inputVehicle(@RequestParam String brand, String type, String plateNumber, int year){
        Boolean isExists = vehicleRepo.existsVehicleByPlateNumber(plateNumber);
        if (isExists){
            return "vehicle sudah tersedia";
        }
        Vehicle vehicle = new Vehicle(brand, type, plateNumber, year);
        vehicleRepo.save(vehicle);
        return "vehicle berhasil diinput";
    }

    @RequestMapping(value = "/getVehicles")
    public String getVehicles(){
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles = vehicleRepo.findAll();
        return vehicles.toString();
    }

    @RequestMapping(value = "/getVehiclesByYear")
    public String getVehiclesByYear(@RequestParam int year){
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles = vehicleRepo.findAllByYear(year);
        if (vehicles.isEmpty()){
            return "vehicle tidak ditemukan";
        }
        return vehicles.toString();
    }

    @RequestMapping(value = "/updateVehicleYearByPlateNumber")
    public String updateVehicleYearByPlateNumber(@RequestParam String plateNumber, int year){
        Vehicle vehicle = new Vehicle();
        vehicle = vehicleRepo.findVehicleByPlateNumber(plateNumber);
        vehicle.setYear(year);
        vehicleRepo.save(vehicle);
        return "vehicle berhasil diupdate";
    }

    @RequestMapping(value = "/deleteVehicleByPlateNumber")
    public String deleteVehicleByPlateNumber(@RequestParam String plateNumber){
        Vehicle vehicle = new Vehicle();
        vehicle = vehicleRepo.findVehicleByPlateNumber(plateNumber);

        if (vehicle == null){
            return "vehicle tidak ditemukan";
        }
        vehicleRepo.delete(vehicle);
        return "vehicle berhasil didelete";
    }

    @RequestMapping(value = "/deleteVehicleById")
    public String deleteVehicleById(@RequestParam Long id){
        Vehicle vehicle = new Vehicle();
        vehicle = vehicleRepo.findVehicleById(id);
        if (vehicle == null){
            return "vehicle tidak ditemukan";
        }
        vehicleRepo.delete(vehicle);
        return "vehicle berhasil didelete";
    }
}
