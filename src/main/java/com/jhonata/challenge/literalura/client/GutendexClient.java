package com.jhonata.challenge.literalura.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jhonata.challenge.literalura.dto.GutendexApiResponse;
import com.jhonata.challenge.literalura.dto.LivroDTO;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@Component
public class GutendexClient {
    private final ObjectMapper mapper = new ObjectMapper();

    public GutendexClient() {
    }

    public List<LivroDTO> consumirApi(String busca) {
        try {
            String url = "https://gutendex.com/books/?search=" + busca;
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            GutendexApiResponse livrosClass = mapper.readValue(response.body(), GutendexApiResponse.class);
            return livrosClass.livroDTOS();
        } catch (IOException | InterruptedException e) {
            System.out.println("Erro ao consumir API: " + e.getMessage());
            return List.of();
        }
    }
}