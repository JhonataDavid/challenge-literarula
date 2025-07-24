package com.jhonata.challenge.literalura.mapper;

import com.jhonata.challenge.literalura.dto.LivroDTO;
import com.jhonata.challenge.literalura.dto.LivroResponseDTO;
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
    @Mapping(source = "downloadCount", target = "numeroDeDownloads")
    LivroEntity dtoToEntity(LivroDTO livroDto);

    @Mapping(source = "titulo", target = "title")
    @Mapping(source = "identificador", target = "id")
    @Mapping(source = "autores", target = "authors")
    @Mapping(source = "idioma", target = "languages")
    @Mapping(source = "numeroDeDownloads", target = "downloadCount")
    LivroDTO entityToDto(LivroEntity livroEntity);

    List<LivroResponseDTO> booksToDtoResponse(List<LivroEntity> livrosEntity);

    @Mapping(source = "title", target = "titulo")
    @Mapping(source = "id", target = "identificador")
    @Mapping(source = "authors", target = "autores")
    @Mapping(source = "languages", target = "idioma")
    @Mapping(source = "downloadCount", target = "numeroDeDownloads")
    LivroResponseDTO booksToDtoResponse(LivroDTO livroDTO);
}
