package com.example.models;

import java.util.Set;
import java.util.UUID;

import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import lombok.AccessLevel;
import lombok.Setter;

public class People {
    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private UUID id;
    private String name;
    @Range(min = 0, max = 300, message = "height:")
    private Integer height;

    @Range(min = 0, max = 250, message = "mass:")
    private Integer mass;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "hair_collor", referencedColumnName = "hairCollor")
    @JsonIgnoreProperties("people")
    private String hairCollor;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "skin_collor", referencedColumnName = "skinCollor")
    @JsonIgnoreProperties("people")
    private String skinCollor;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "eye_color", referencedColumnName = "eyeCollor")
    @JsonIgnoreProperties("people")
    private String eyeCollor;

    @Range(min = 0000, max = 3000, message = "birth_year:")
    private Integer birthYear;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "gender", referencedColumnName = "gender")
    @JsonIgnoreProperties("people")
    private String gender;

    @ManyToMany
    @JoinTable(name = "homeworld", joinColumns = @JoinColumn(name = "homeworld:"), inverseJoinColumns = @JoinColumn(name = "homeworld:"))
    @JsonIgnore
    private Set<Homeworld> homeworld;

    @ManyToMany
    @JoinTable(name = "films", joinColumns = @JoinColumn(name = "films:"), inverseJoinColumns = @JoinColumn(name = "films:"))
    @JsonIgnore
    private Set<Film> films;

    @ManyToMany
    @JoinTable(name = "vehicles", joinColumns = @JoinColumn(name = "vehicles:"), inverseJoinColumns = @JoinColumn(name = "vehicles:"))
    @JsonIgnore
    private Set<Vehicle> vehicles;

}
