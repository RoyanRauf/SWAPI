package com.example.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.Vehicle;
import com.example.service.VehicleService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @GetMapping
    public List<Vehicle> getAllVehicles(){
        return vehicleService.getAllVehicles();
    }
    @GetMapping("/{id}")
    public Vehicle getVehicleById(@PathVariable Long id){
        return vehicleService.getVehicleById(id);
    }
    @PostMapping
    public Vehicle createVehicle(@RequestBody Vehicle vehicle) {
        return vehicleService.creatVehicle(vehicle);
    }

    @PutMapping("/{id}")
    public Vehicle updateVehicle(@PathVariable Long id, @RequestBody Vehicle vehicle) {
        return vehicleService.updatVehicle(id,vehicle);
    }
    @PutMapping("/{id}")
    public Vehicle updatVehicle(@PathVariable Long id, @RequestBody Vehicle vehicle){
        return vehicleService.updatVehicle(id, vehicle);
    }
    @DeleteMapping("/{id}")
    public void deleteVehicle(@PathVariable Long id , @RequestBody Vehicle vehicle){
        vehicleService.deleteVehicle(id);
    }
}
