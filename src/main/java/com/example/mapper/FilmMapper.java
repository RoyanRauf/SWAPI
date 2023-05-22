package com.example.mapper;

import com.example.models.Film;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.io.IOException;

public class FilmMapper {
    private final ObjectMapper objectMapper;

    public FilmMapper() {
        this.objectMapper = new ObjectMapper();
    }

    public Film map(String json) throws IOException, JsonMappingException, JsonProcessingException {
        return objectMapper.readValue(json, Film.class);
    }

}
