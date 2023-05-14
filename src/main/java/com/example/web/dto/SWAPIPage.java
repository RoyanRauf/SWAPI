package com.example.web.dto;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class SWAPIPage {

    public static void main(String[] args){
        String baseUrl = "https://swapi.dev/api/";
        String resources = "people/1/";
        String endPoint = baseUrl + resources;

        try{
            URL url = new URL (endPoint);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputeLine;
            StringBuffer content = new StringBuffer();
            while ((inputeLine = in.readLine()) != null){
                content.append(inputeLine);
            }
            in.close();
            System.out.println(content.toString());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    
    
}
