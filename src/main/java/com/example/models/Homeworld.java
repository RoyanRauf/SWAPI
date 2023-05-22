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

public class Homeworld {
	@GeneratedValue
	@Setter(AccessLevel.NONE)
	private String Planetname;

	@Range(min = 0, max = 50, message = "rotation_period:")
	private Integer rotationPeriod;

	@Range(min = 0, max = 500, message = "orbital_period:")
	private Integer orbitalPeriod;

	@Range(min = 10, max = 999999, message = "diameter:")
	private Integer diameter;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "climate", referencedColumnName = "climate")
	@JsonIgnoreProperties("homeworld")
	private String cliamte;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "gravity", referencedColumnName = "gravity")
	@JsonIgnoreProperties("homeworld")
	private String gravity;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "terrian", referencedColumnName = "terrian")
	@JsonIgnoreProperties("homeworld")
	private String terrian;

	@Range(min = 0, max = 40, message = "surface_water:")
	private Integer surfaceWater;

	@Range(min = 0, max = 999999999, message = "population:")
	private Integer population;

	@ManyToMany
	@JoinTable(name = "films", joinColumns = @JoinColumn(name = "films:"), inverseJoinColumns = @JoinColumn(name = "films:"))
	@JsonIgnore
	private Set<Film> films;
}
