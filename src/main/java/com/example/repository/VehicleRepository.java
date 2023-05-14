package com.example.repository;

import java.util.ArrayList;
import java.util.List;



import com.example.models.Vehicle;

public class VehicleRepository extends Vehicle{
    private final List<Vehicle> vehicles;

    public VehicleRepository() {
        this.vehicles = new ArrayList<>();
    }

    public Vehicle save(Vehicle vehicle) {
        vehicles.add(vehicle);
        return vehicle;
    
    }
    public List<Vehicle> findAll(){
        return new ArrayList<>(vehicles);
    }
     public Vehicle findById(Long id){
        return vehicles.stream()
        .filter(Vehicle -> Vehicle.getId() == id)
        .findFirst()
        .orElse(null);
        
     }

    public void deleteById(Long id) {
    }
    
}
