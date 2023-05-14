package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.models.Vehicle;
import com.example.repository.VehicleRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    public List<Vehicle> getAllVehicles(){
        return vehicleRepository.findAll();
    }
    public Vehicle getVehicleById(Long id){
        return vehicleRepository.findById(id)
        .orElseThrow(() -> EntityNotFoundException("Vehicle not found with id: " + id));
    }
    
    public Vehicle creatVehicle(Vehicle vehicle){
        return vehicleRepository.save(vehicle);
    }
    public Vehicle updatVehicle(Long id, Vehicle vehicle){
        Vehicle existingVehicle = getVehicleById(id);
        existingVehicle.setName(vehicle.getName());
        existingVehicle.setModel(vehicle.getModel());
        existingVehicle.setManufactorer(vehicle.getManufactorer());
        existingVehicle.setCost_in_credits(vehicle.getCost_in_credits());
        existingVehicle.setLength(vehicle.getLength());
        existingVehicle.setMax_atmosphering_speed(vehicle.getMax_atmosphering_speed());
        existingVehicle.setCrew(vehicle.getCrew());
        existingVehicle.setPassengers(vehicle.getPassengers());
        existingVehicle.setCargo_capacity(vehicle.getCargo_capacity());
        existingVehicle.setConsumables(vehicle.getConsumables());
        existingVehicle.setVehicle_class(vehicle.getVehicle_class());
        existingVehicle.setPilots(vehicle.getPilots());
        return vehicleRepository.save(existingVehicle);
    }
    public void deleteVehicle(Long id) {
        vehicleRepository.deleteById(id);
    }

   
}
