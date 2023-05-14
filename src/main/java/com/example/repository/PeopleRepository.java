package com.example.repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.boot.autoconfigure.cassandra.CassandraProperties.Request;

import com.amazonaws.internal.config.Builder;
import com.example.models.People;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PeopleRepository<OkHttpClient> {
    private final String baseUrl;

    public PeopleRepository(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public List<People> getAllPeople() throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Builder()
                .url(baseUrl + "/people/")
                .build();
        Response response = client.newCall(request).execute();
        if (response.isSuccessful()) {
            String responseBody = response.body().string();
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(responseBody);
            JsonNode results = root.get("results");
            List<Person> people = new ArrayList<>();
            for (JsonNode result : results) {
                Person person = mapper.treeToValue(result, Person.class);
                people.add(person);
            }
            return people;
        } else {
            throw new IOException("Unexpected response: " + response);
        }
    }

    public Person getPersonById(int id) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(baseUrl + "/people/" + id)
                .build();
        Response response = client.newCall(request).execute();
        if (response.isSuccessful()) {
            String responseBody = response.body().string();
            ObjectMapper mapper = new ObjectMapper();
            Person person = mapper.readValue(responseBody, Person.class);
            return person;
        } else if (response.code() == 404) {
            return null; // Person not found
        } else {
            throw new IOException("Unexpected response: " + response);
        }
    }
}