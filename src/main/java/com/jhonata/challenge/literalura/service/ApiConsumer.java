package com.jhonata.challenge.literalura.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.jhonata.challenge.literalura.dto.GutendexApiResponse;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiConsumer {

    public static void main(String[] args) throws Exception {
        HttpClient client = HttpClient.newBuilder()
                .followRedirects(HttpClient.Redirect.ALWAYS)
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://gutendex.com/books"))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("Status: " + response.statusCode());
        System.out.println("Corpo: " + response.body());

        ObjectMapper mapper = new ObjectMapper();
        GutendexApiResponse livros = mapper.readValue(response.body(), GutendexApiResponse.class);

        livros.livroDtos()
                .forEach(System.out::println);
    }
}