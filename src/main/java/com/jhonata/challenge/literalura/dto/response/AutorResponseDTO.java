package com.jhonata.challenge.literalura.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record AutorResponseDTO(String nome, Integer dataNascimento, Integer dataFalecimento) {
}
