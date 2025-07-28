package com.jhonata.challenge.literalura.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class LivroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private int identificador;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "livro_autor",
            joinColumns = @JoinColumn(name = "livro_id"), //cria coluna com chave primaria do Livro
            inverseJoinColumns = @JoinColumn(name = "autor_id")) //cria coluna com chave primaria do Autor
    private List<AutorEntity> autores;
    @ElementCollection
    private List<String> idioma;
    private int numeroDeDownloads;
}
