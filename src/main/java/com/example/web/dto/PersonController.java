package com.example.web.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.PersonService;

@RestController
@RequestMapping("/people")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/{id}")
    public ResponseEntity<PersonDto> getPersonById()
    
}
