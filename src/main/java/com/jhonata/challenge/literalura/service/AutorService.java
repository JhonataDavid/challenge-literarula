package com.jhonata.challenge.literalura.service;

import com.jhonata.challenge.literalura.dto.response.AutorCompletoDTO;
import com.jhonata.challenge.literalura.mapper.AutorMapper;
import com.jhonata.challenge.literalura.model.AutorEntity;
import com.jhonata.challenge.literalura.repository.AutorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AutorService {

    private final AutorRepository repository;
    private final AutorMapper autorMapper;

    public AutorService(AutorRepository repositry, AutorMapper autorMapper) {
        this.repository = repositry;
        this.autorMapper = autorMapper;
    }

    @Transactional
    public List<AutorCompletoDTO> buscarTodosAutores() {
        List<AutorEntity> autorEntity = repository.findAll();
        return autorMapper.entityToAutorCompletoRespondeDto(autorEntity);
    }

    @Transactional
    public List<AutorCompletoDTO> buscarAutoresPeloAno(Integer ano) {
        List<AutorEntity> todosAutores = repository.findAll();
        List<AutorEntity> autoresFiltrados = todosAutores.stream()
                .filter(autor ->
                        autor.getDataNascimento() != null &&
                                autor.getDataNascimento() <= ano &&
                                (autor.getDataFalecimento() == null || autor.getDataFalecimento() > ano)
                ).toList();
        return autorMapper.entityToAutorCompletoRespondeDto(autoresFiltrados);
    }


}
