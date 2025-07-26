package com.jhonata.challenge.literalura.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class LivroResponseDTO {
    int identificador;
    String titulo;
    List<AutorDTO> autores;
    List<String> idioma;
    Integer numeroDeDownloads;

    @Override
    public String toString() {
        return "\n  título: " + titulo +
                ",\n  autor: " + autores.getFirst().name() +
                ",\n  identificador: " + identificador +
                ",\n  idioma: " + idioma +
                ",\n  número de downloads: " + numeroDeDownloads;
    }
}
