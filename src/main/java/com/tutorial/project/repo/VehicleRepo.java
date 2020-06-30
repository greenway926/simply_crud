package com.tutorial.project.repo;

import com.tutorial.project.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleRepo extends JpaRepository<Vehicle, Long> {

    public Boolean existsVehicleByPlateNumber(String plateNumber);
    public List<Vehicle> findAllByYear(int year);
    public Vehicle findVehicleByPlateNumber(String plateNumber);
    public Vehicle findVehicleById(Long id);

}
