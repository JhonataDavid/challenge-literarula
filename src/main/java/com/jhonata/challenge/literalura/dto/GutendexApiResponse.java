package com.jhonata.challenge.literalura.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record GutendexApiResponse(
        int count,
        String next,
        String previous,
        @JsonAlias("results")
        List<LivroDto> livroDtos) {
}
