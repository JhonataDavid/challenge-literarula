package com.jhonata.challenge.literalura.service;

import com.jhonata.challenge.literalura.client.GutendexClient;
import com.jhonata.challenge.literalura.dto.LivroDTO;
import com.jhonata.challenge.literalura.dto.LivroResponseDTO;
import com.jhonata.challenge.literalura.mapper.LivroMapper;
import com.jhonata.challenge.literalura.model.LivroEntity;
import com.jhonata.challenge.literalura.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    private final LivroRepository repository;
    private final LivroMapper livroMapper;
    private GutendexClient client;

    public LivroService(LivroRepository livroRepository, LivroMapper livroMapper, GutendexClient client) {
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
                    return livroMapper.booksToDtoResponse(dto);
                });
    }

    public LivroDTO saveBook(LivroDTO livroDto) {
        LivroEntity livro = livroMapper.dtoToEntity(livroDto); //Transforma o Dto no Entity.
//        if (livro.getAutores() != null){
//            livro.getAutores().forEach(autorEntity -> autorEntity.setLivro(livro));
//        }
        this.repository.save(livro); //Salva a minha Entity.
        return livroMapper.entityToDto(livro); //Ja retorna um Dto.
    }

    public List<LivroResponseDTO> getAllBooks() {
        List<LivroEntity> livrosEntities = repository.findAll();
        return livroMapper.booksToDtoResponse(livrosEntities);
    }
}
