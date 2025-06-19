package com.closetDigit.maps;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import com.closetDigit.dtos.CategoriaDTO;
import com.closetDigit.entity.Categoria;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {

    CategoriaDTO entityToDto(Categoria categoria);

    @InheritInverseConfiguration
    Categoria dtoToEntity(CategoriaDTO dto);
}
