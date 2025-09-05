package com.closetDigit.maps;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.closetDigit.dtos.ProductoDTO;
import com.closetDigit.entity.Producto;


@Mapper(componentModel = "spring")
public interface ProductoMapper {
	ProductoMapper INSTANCE = Mappers.getMapper(ProductoMapper.class);

	ProductoDTO entityToDto(Producto producto);

    @InheritInverseConfiguration
    Producto dtoToEntity(ProductoDTO dto);

}
