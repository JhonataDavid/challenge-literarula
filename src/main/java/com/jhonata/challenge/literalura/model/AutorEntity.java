package com.jhonata.challenge.literalura.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity(name = "Autor")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AutorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private Integer dataNascimento;
    private Integer dataFalecimento;

}