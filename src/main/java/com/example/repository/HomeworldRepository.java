package com.example.repository;

import java.net.URL;
import java.util.List;

import org.apache.catalina.mapper.Mapper;

import com.example.SwapiResult;
import com.example.mapper.HomeworldMapper;
import com.example.models.Homeworld;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.io.IOException;
import jakarta.websocket.Endpoint;

public class HomeworldRepository {
    private final String SWAPI_BASE_URL = "https:swapi.dev/api/";
    private final String HOMEWORLD_ENDPOINT = "planets/";
    private final ObjectMapper objectMapper;
    private final HomeworldMapper homeworldMapper;

    public HomeworldRepository() {
        this.objectMapper = new ObjectMapper();
        this.homeworldMapper = new HomeworldMapper();
    }

    public List<Homeworld> findAll() throws IOException{
        String homeworldJson = fetchJsonFromEndpoint(HOMEWORLD_ENDPOINT);
        SwapiResult<Homeworld> swapiResult = objectMapper.readValue(homeworldJson, new TypeReference<SwapiResult<Homeworld>>()){}
        return swapiResult.getResults();
    }

    public Homeworld findById(int id)throws IOException{
        String homeworldJson = fetchJsonFromEndpoint(HOMEWORLD_ENDPOINT + id + "/");
        return Mapper.map(homeworldJson);
    }

    private String fetchJsonFromEndpoint(String hOMEWORLD_ENDPOINT2HOMEWORLD_ENDPOINT + id + "/"){
    URL url = new URL (SWAPI_BASE_URL + endpoint);
    try (InputeStream InputeStream = url.openStream());
    return new String(inputStream.readAllBytes());
    }


}
