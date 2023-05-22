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

public class Film {
    @GeneratedValue
@Setter(AccessLevel.NONE)
private String name;


@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
@JoinColumn(name = "title", referencedColumnName = "title")
@JsonIgnoreProperties("film")
private String title;

@Range(min = 0, max = 1000 , message = "episode_id:")
private Integer episodeId;

@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
@JoinColumn(name = "openingCraw", referencedColumnName = "opening_craw")
@JsonIgnoreProperties("film")
private String openingCraw;

@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
@JoinColumn(name = "director", referencedColumnName = "director")
@JsonIgnoreProperties("film")
private String director;
   
@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
@JoinColumn(name = "producer", referencedColumnName = "producer")
@JsonIgnoreProperties("film")
private String producer;

/**
 *
 */
@Range(min = 0000-00-00, max = 9999-12-31 , message = "release_date:")
private Integer releaseDate;

@ManyToMany
    @JoinTable(name = "characters", joinColumns = @JoinColumn(name = "characters"), inverseJoinColumns = @JoinColumn(name = "characters"))
    @JsonIgnore
    private Set<People> people;

	@ManyToMany
    @JoinTable(name = "planets", joinColumns = @JoinColumn(name = "planets"), inverseJoinColumns = @JoinColumn(name = "planets"))
    @JsonIgnore
    private Set<Homeworld> homeworlds;

	@ManyToMany
    @JoinTable(name = "vehicles", joinColumns = @JoinColumn(name = "vehicles"), inverseJoinColumns = @JoinColumn(name = "vehicles"))
    @JsonIgnore
    private Set<Vehicle> vehicle;
	
}
