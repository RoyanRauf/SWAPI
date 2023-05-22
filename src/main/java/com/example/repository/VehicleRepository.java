package com.example.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.models.Vehicle;
@Repository
public class VehicleRepository extends CrudRepository<Vehicle,UUID>{


}


    