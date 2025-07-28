package com.jhonata.challenge.literalura.dto.response;

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
    private int identificador;
    private String titulo;
    private List<AutorResponseDTO> autores;
    private List<String> idioma;
    private Integer numeroDeDownloads;

    @Override
    public String toString() {
        return "\n  título: " + titulo +
                ",\n  autor: " + autores.getFirst().nome() +
                ",\n  identificador: " + identificador +
                ",\n  idioma: " + idioma.getFirst() +
                ",\n  número de downloads: " + numeroDeDownloads;
    }
}
