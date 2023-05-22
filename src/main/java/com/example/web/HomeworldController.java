package com.example.web;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.example.web.dto.PeopleResponse;

import io.jsonwebtoken.io.IOException;

public class HomeworldController {
    private static final String CharacterR = null;
    private static final String PeopleR = null;
    private final String SWAPI_BASE_URL = "https://swapi.dev/api/";

    public Homeworld getHomeworld(int characterId)throws IOException{
        String characterUrl = SWAPI_BASE_URL + "people/" + characterId + "/";
        String homeworldUrl = "";
        
        HttpURLConnection connection = (HttpURLConnection) new URL(characterUrl).openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK){
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null){
                response.append(line);
            }
            reader.close();

            Gson gson = new Gson();
            PeopleResponse peopleResponse = gson.fromJson(response.toString(), PeopleResponse.class);
            homeworldUrl = peopleResponse.homeworld;
        }
        
        connection = (HttpURLConnection) new URL(homeworldUrl).openConnection();
        connection.setRequestMethod("GET");

        responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK){
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null){
                response.append(line);
            }
            reader.close();

            Homeworld homeworld = gson.fromJson(response.toString(), Homeworld.class);
            return homeworld;
        }
        return null;

    }
    public static void main(String[] args) {
        HomeworldController controller = new HomeworldController();
        int characterId = 1;
        try{
            Homeworld homeworld = controller.getHomeworld(characterId);
            System.out.println(homeworld.getName());
        } catch (IOException e){
            e.printStackTrace();
        }
        
    }
    private static class CharacterResponse{
        String homeworld;
    }
    public static class Homeworld{
        String name;
    String rotation_period;
    String orbital_period;
    String diameter;
    String climate;
    String gravity;
    String terrain;
    String surface_water;
    String population;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getRotation_period() {
        return rotation_period;
    }
    public void setRotation_period(String rotation_period) {
        this.rotation_period = rotation_period;
    }
    public String getOrbital_period() {
        return orbital_period;
    }
    public void setOrbital_period(String orbital_period) {
        this.orbital_period = orbital_period;
    }
    public String getDiameter() {
        return diameter;
    }
    public void setDiameter(String diameter) {
        this.diameter = diameter;
    }
    public String getClimate() {
        return climate;
    }
    public void setClimate(String climate) {
        this.climate = climate;
    }
    public String getGravity() {
        return gravity;
    }
    public void setGravity(String gravity) {
        this.gravity = gravity;
    }
    public String getTerrain() {
        return terrain;
    }
    public void setTerrain(String terrain) {
        this.terrain = terrain;
    }
    public String getSurface_water() {
        return surface_water;
    }
    public void setSurface_water(String surface_water) {
        this.surface_water = surface_water;
    }
    public String getPopulation() {
        return population;
    }
    public void setPopulation(String population) {
        this.population = population;
    }
    
    }
    
    
    
    
}
