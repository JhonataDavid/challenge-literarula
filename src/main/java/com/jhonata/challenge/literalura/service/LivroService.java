package com.jhonata.challenge.literalura.service;

import com.jhonata.challenge.literalura.client.GutendexClient;
import com.jhonata.challenge.literalura.dto.external.LivroDTO;
import com.jhonata.challenge.literalura.dto.response.LivroResponseDTO;
import com.jhonata.challenge.literalura.mapper.AutorMapper;
import com.jhonata.challenge.literalura.mapper.LivroMapper;
import com.jhonata.challenge.literalura.model.LivroEntity;
import com.jhonata.challenge.literalura.repository.LivroRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    private final LivroRepository repository;
    private final LivroMapper livroMapper;
    private final GutendexClient client;

    public LivroService(LivroRepository livroRepository, LivroMapper livroMapper, GutendexClient client, AutorMapper autorMapper) {
        this.repository = livroRepository;
        this.livroMapper = livroMapper;
        this.client = client;
    }

    public Optional<LivroResponseDTO> buscarLivros(String livroNome) {
        String nomeFormatado = livroNome.toLowerCase().replace(" ", "+");
        return this.client.consumirApi(nomeFormatado)
                .stream()
                .findFirst()
                .map(dto -> {
                    saveBook(dto);
                    return livroMapper.dtoToDtoResponse(dto);
                });
    }

    @Transactional
    public LivroDTO saveBook(LivroDTO livroDto) {
        LivroEntity livro = livroMapper.dtoToEntity(livroDto); //Transforma o Dto no Entity.
        repository.save(livro); //Salva a minha Entity.
        return livroMapper.entityToDto(livro); //Ja retorna um Dto.
    }

    @Transactional
    public List<LivroResponseDTO> getAllBooks() {
        List<LivroEntity> livrosEntities = repository.findAll();
        return livroMapper.entityToDtoResponse(livrosEntities);
    }

    @Transactional
    public List<LivroResponseDTO> buscarLivrosPorIdioma(String idiomaBuscado) {
        List<LivroEntity> livros = repository.findAll();
        List<LivroEntity> filtrados = livros.stream()
                .filter(livro -> livro.getIdioma() != null && livro.getIdioma().contains(idiomaBuscado))
                .toList();
        return livroMapper.entityToDtoResponse(filtrados);
    }
}
