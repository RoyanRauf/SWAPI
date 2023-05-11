package com.example.repository;

import java.io.IOException;
import java.net.URL;

import com.example.SwapiResult;
import com.example.mapper.FilmMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.validation.OverridesAttribute.List;

public class FilmRepository<Film> { 
    private final String SWAPI_BASE_URL = "https://swapi.dev/api/";
    private final String FILMS_ENDPOINT = "films/";
    private final ObjectMapper objectMapper;
    private final FilmMapper filmMapper;

    public FilmRepository() {
        this.objectMapper = new ObjectMapper();
        this.filmMapper = new FilmMapper();
    }

    public  List<Film> findAll() throws IOException {
        String filmJson = fetchJsonFromEndpoint(FILMS_ENDPOINT);
        SwapiResult<Film> swapiResult objectMapper.readValue(filmJson, new TypeReference<SwapiResult<Film>(){});
        return swapiResult.getResults();

    }

    public Film findById(int id) throws IOException{
        String filmjson = fetchJsonFromEndpoint(FILMS_ENDPOINT + id + "/");
        return (Film) new String(inputStream.readAllBytes));
    }
    private String fetchJsonFromEndpoint(String endpoint) throws IOException{
        URL url = new URL(SWAPI_BASE_URL + endpoint);
        try (InputStream inputStream = url.openStream()) {
            return new String(inputStream.readAllBytes());
        }
    }

	private String fetchJsonFromEndpoint(String fILMS_ENDPOINT2) {
		return null;
	}
    
}
 