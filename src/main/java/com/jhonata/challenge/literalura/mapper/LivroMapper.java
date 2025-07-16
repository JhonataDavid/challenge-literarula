package com.jhonata.challenge.literalura.mapper;

import com.jhonata.challenge.literalura.dto.LivroDto;
import com.jhonata.challenge.literalura.model.LivroEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface LivroMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "id", target = "identificador")
    @Mapping(source = "authors", target = "autores")
    LivroEntity mapLivroEntityToLivroDto(LivroDto livroDto);
}
