package com.jhonata.challenge.literalura.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record AutorDto(String name, Integer birth_year, Integer death_year) {
}
