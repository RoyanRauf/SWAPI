package com.example.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.example.web.dto.FilmResponse;
@RequestController
@RequestMapping
public class FilmController {
    private static final String SWAPI_BASE_URL = "https://swapi.dev/api";

    private final RestTemplate restTemplate;

    public FilmController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/{id}")
    public ResponseEntity<FilmResponse> getFilmById(@PathVariable("id") int id) {
        String url = SWAPI_BASE_URL + "/films/" + id + "/";
        FilmResponse filmResponseDTO = restTemplate.getForObject(url, FilmResponse.class);
        if (filmResponseDTO != null) {
            return ResponseEntity.ok(filmResponseDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
}
