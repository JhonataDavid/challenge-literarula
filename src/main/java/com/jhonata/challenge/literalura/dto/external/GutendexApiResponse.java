package com.jhonata.challenge.literalura.dto.external;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record GutendexApiResponse(
        int count,
        String next,
        String previous,
        @JsonAlias("results")
        List<LivroDTO> livroDTOS,
        List<String> languages,
        Integer download_count) {
}
