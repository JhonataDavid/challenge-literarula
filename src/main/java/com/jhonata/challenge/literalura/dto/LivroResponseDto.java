package com.jhonata.challenge.literalura.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record LivroResponseDto(int identificador, String titulo, List<AutorDto> autores){
}
