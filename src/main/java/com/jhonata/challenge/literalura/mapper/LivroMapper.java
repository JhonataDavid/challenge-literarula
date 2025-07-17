package com.jhonata.challenge.literalura.mapper;

import com.jhonata.challenge.literalura.dto.LivroDto;
import com.jhonata.challenge.literalura.dto.LivroResponseDto;
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
    LivroEntity dtoToEntity(LivroDto livroDto);

    @Mapping(source = "titulo", target = "title")
    @Mapping(source = "identificador", target = "id")
    @Mapping(source = "autores", target = "authors")
    LivroDto entityToDto(LivroEntity livroEntity);

    List<LivroResponseDto> booksToDtoResponse(List<LivroEntity> livrosEntity);
}
