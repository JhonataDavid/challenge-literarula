package com.jhonata.challenge.literalura.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record LivroResponseDTO(int identificador,
                               String titulo,
                               List<AutorDTO> autores,
                               List<String> idioma,
                               Integer numeroDeDownloads) {
}
