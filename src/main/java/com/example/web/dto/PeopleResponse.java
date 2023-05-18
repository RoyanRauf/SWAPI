package com.example.web.dto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class PeopleResponse {

    public static final String homeworld = null;
    public static void main(String[] args) {
        String baseUrl = "https://swapi.dev/api";
        
        getCharacter(1, baseUrl);
    }
    private static void getCharacter(int characterId, String baseUrl){
        try{
            String url = baseUrl + "/people/" + characterId + "/";

            URL apiUrl = new URL(url);

            HttpURLConnection connection = (HttpURLConnection) apiUrl.openConnection();

            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK){

                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                StringBuilder response = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                System.out.println("Response: " + response.toString());
            }else{
                System.out.println("Failed to retrieve character information. Response code: " + responseCode);

            }

            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
