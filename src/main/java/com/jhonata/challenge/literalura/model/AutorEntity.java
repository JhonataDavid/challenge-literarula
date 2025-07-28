package com.jhonata.challenge.literalura.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "Autor")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class AutorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private Integer dataNascimento;
    private Integer dataFalecimento;
    @ManyToMany(mappedBy = "autores")
    private List<LivroEntity> livros;
}