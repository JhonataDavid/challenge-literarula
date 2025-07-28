package com.jhonata.challenge.literalura.dto.response;

import com.jhonata.challenge.literalura.model.AutorEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class AutorCompletoDTO {
    private String nome;
    private Integer dataNascimento;
    private Integer dataFalecimento;
    private List<LivroResponseDTO> livros;


    public AutorCompletoDTO(AutorEntity autorEntity, List<LivroResponseDTO> livros) {
        this.nome = autorEntity.getNome();
        this.dataNascimento = autorEntity.getDataNascimento();
        this.dataFalecimento = autorEntity.getDataFalecimento();
        this.livros = livros;
    }

    @Override
    public String toString() {
        return "AutorCompletoDTO{" +
                "nome='" + nome + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", dataFalecimento=" + dataFalecimento +
                ", livros=" + livros+
                '}';
    }
}

