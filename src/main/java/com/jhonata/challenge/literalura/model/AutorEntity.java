package com.jhonata.challenge.literalura.model;

import jakarta.persistence.*;
import lombok.*;

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
    @ManyToOne
    @JoinColumn(name = "livro_id") // cria a chave estrangeira
    private LivroEntity livro;
}