package com.jhonata.challenge.literalura.mapper;

import com.jhonata.challenge.literalura.dto.external.LivroDTO;
import com.jhonata.challenge.literalura.dto.response.LivroResponseDTO;
import com.jhonata.challenge.literalura.model.LivroEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {AutorMapper.class})
public interface LivroMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "title", target = "titulo")
    @Mapping(source = "id", target = "identificador")
    @Mapping(source = "authors", target = "autores")
    @Mapping(source = "languages", target = "idioma")
    @Mapping(source = "download_count", target = "numeroDeDownloads")
    LivroEntity dtoToEntity(LivroDTO livroDto);

    @Mapping(source = "titulo", target = "title")
    @Mapping(source = "identificador", target = "id")
    @Mapping(source = "autores", target = "authors")
    @Mapping(source = "idioma", target = "languages")
    @Mapping(source = "numeroDeDownloads", target = "download_count")
    LivroDTO entityToDto(LivroEntity livroEntity);

    @Mapping(source = "title", target = "titulo")
    @Mapping(source = "id", target = "identificador")
    @Mapping(source = "authors", target = "autores")
    @Mapping(source = "languages", target = "idioma")
    @Mapping(source = "download_count", target = "numeroDeDownloads")
    LivroResponseDTO dtoToDtoResponse(LivroDTO livroDTO);

    LivroResponseDTO entityToDtoResponse(LivroEntity livroEntity);

    @Mapping(source = "title", target = "titulo")
    @Mapping(source = "id", target = "identificador")
    @Mapping(source = "authors", target = "autores")
    @Mapping(source = "languages", target = "idioma")
    @Mapping(source = "download_count", target = "numeroDeDownloads")
    List<LivroResponseDTO> entityToDtoResponse(List<LivroEntity> livrosEntity);
}
