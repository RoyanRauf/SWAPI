package com.example.web;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;

public class PeopleController<Public> {
    private static final String BASE_URL = "https://swapi.dev/api";

    public String getPerson(int personId) {
        String apiUrl = BASE_URL + "/pepole" + personId + "/";
        try {
            URL url = new URL(apiUrl);
            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int responseCode = conn.getReadTimeout();
            if (responseCode == 200) {
                StringBuilder response = new StringBuilder();
                Scanner scanner = new Scanner(conn.getInputStream());
                while (scanner.hasNextLine()) {
                    response.append(scanner.nextLine());
                }
                scanner.close();
                return response.toString();

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }



    
}


