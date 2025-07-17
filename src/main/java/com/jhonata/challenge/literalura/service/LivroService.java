package com.jhonata.challenge.literalura.service;

import com.jhonata.challenge.literalura.dto.LivroDto;
import com.jhonata.challenge.literalura.dto.LivroResponseDto;
import com.jhonata.challenge.literalura.mapper.LivroMapper;
import com.jhonata.challenge.literalura.model.LivroEntity;
import com.jhonata.challenge.literalura.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    private final LivroRepository repository;
    private final LivroMapper livroMapper;

    public LivroService(LivroRepository livroRepository, LivroMapper livroMapper) {
        this.repository = livroRepository;
        this.livroMapper = livroMapper;
    }

    public LivroDto saveBook(LivroDto livroDto) {
        LivroEntity livro = livroMapper.dtoToEntity(livroDto); //Transforma o Dto no Entity.
        if (livro.getAutores() != null) {
            livro.getAutores().forEach(autor -> autor.setLivro(livro));
        }
        this.repository.save(livro); //Salva a minha Entity.
        return livroMapper.entityToDto(livro); //Ja retorna um Dto.
    }


    public List<LivroResponseDto> getAllBooks(){
        List<LivroEntity> livrosEntities = repository.findAll();
        return livroMapper.booksToDtoResponse(livrosEntities);
    }
}
