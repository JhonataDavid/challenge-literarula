package com.jhonata.challenge.literalura.mapper;

import com.jhonata.challenge.literalura.dto.AutorDTO;
import com.jhonata.challenge.literalura.model.AutorEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AutorMapper {

    @Mapping(source = "name", target = "nome")
    @Mapping(source = "birth_year", target = "dataNascimento")
    @Mapping(source = "death_year", target = "dataFalecimento")
    AutorEntity dtoToEntity(AutorDTO autorDto);

    @Mapping(source = "nome", target = "name")
    @Mapping(source = "dataNascimento", target = "birth_year")
    @Mapping(source = "dataFalecimento", target = "death_year")
    AutorDTO entityToDto(AutorEntity autorEntity);
}
