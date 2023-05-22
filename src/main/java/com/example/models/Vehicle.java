package com.example.models;

import java.util.Set;

import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import lombok.AccessLevel;
import lombok.Setter;

public class Vehicle {
    @GeneratedValue
	@Setter(AccessLevel.NONE)
	private String name;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "model", referencedColumnName = "model")
    @JsonIgnoreProperties("vehicle")
    private String model;
    
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "manufacture", referencedColumnName = "manufacture")
    @JsonIgnoreProperties("vehicle")
    private String manufacture;

	@Range(min = 0, max = 99999999, message = "cost_in_credit:")
	private String costInCredit;
    
    @Range(min = 0, max = 50, message = "lenght:" )
    private Double lenght;

    @Range(min = 0, max = 10000, message = "max_atmosphering_speed:")
    private Integer maxAtmospheringSpeed;

    @Range(min = 0, max = 100, message = "crew:")
    private Integer crew;

    @Range(min = 0, max = 100, message = "passengers:")
    private Integer passengers;

    @Range(min = 0, max = 10000000, message = "cargo_capacity")
    private Integer cargoCapacity;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "consumables", referencedColumnName = "consumables")
    @JsonIgnoreProperties("vehicle")
    private String consumables;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "vehicle_class", referencedColumnName = "vehicle_class")
    @JsonIgnoreProperties("vehicle")
    private String vehicleClass;

    @ManyToMany
    @JoinTable(name = "pilots", joinColumns = @JoinColumn(name = "pilots:"), inverseJoinColumns = @JoinColumn(name = "pilots:"))
    @JsonIgnore
    private Set<People> peoples;

    @ManyToMany
    @JoinTable(name = "films", joinColumns = @JoinColumn(name = "films:"), inverseJoinColumns = @JoinColumn(name = "films:"))
    @JsonIgnore
    private Set<Film> films;
}