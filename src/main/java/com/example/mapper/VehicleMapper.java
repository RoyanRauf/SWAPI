package com.example.mapper;

import com.example.models.Vehicle;
import com.fasterxml.jackson.databind.ObjectMapper;

public class VehicleMapper {
    private final ObjectMapper objectMapper;

   public VehicleMapper() {
    this.objectMapper = new ObjectMapper();

    }

    public Vehicle map(String json) throws Exception {
        return objectMapper.readValue(json, Vehicle.class);
    }
    
}
