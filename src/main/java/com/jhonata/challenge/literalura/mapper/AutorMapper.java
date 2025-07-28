package com.jhonata.challenge.literalura.mapper;

import com.jhonata.challenge.literalura.dto.external.AutorDTO;
import com.jhonata.challenge.literalura.dto.response.AutorCompletoDTO;
import com.jhonata.challenge.literalura.dto.response.AutorResponseDTO;
import com.jhonata.challenge.literalura.model.AutorEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

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

    @Mapping(source = "name", target = "nome")
    @Mapping(source = "birth_year", target = "dataNascimento")
    @Mapping(source = "death_year", target = "dataFalecimento")
    AutorResponseDTO autorDtoToAutorResponse(AutorDTO autorDTO);

    AutorResponseDTO entityToResponseDTO(AutorEntity autorEntity);

    @Mapping(source = "nome", target = "nome")
    @Mapping(source = "dataNascimento", target = "dataNascimento")
    @Mapping(source = "dataFalecimento", target = "dataFalecimento")
    @Mapping(source = "livros", target = "livros")
    AutorCompletoDTO entityToAutorCompletoDTO(AutorEntity autorEntity);

    List<AutorCompletoDTO> entityToAutorCompletoRespondeDto(List<AutorEntity> autorEntity);

    List<AutorResponseDTO> entityToResponseDTOs(List<AutorEntity> autorEntity);
}
