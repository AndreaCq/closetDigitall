package com.closetDigit.maps;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.closetDigit.dtos.ClienteDTO;
import com.closetDigit.entity.Cliente;


@Mapper (componentModel = "spring")
public interface ClienteMappers {

	ClienteMappers INSTANCE = Mappers.getMapper(ClienteMappers.class);

    ClienteDTO entityToDto(Cliente cliente);

    @InheritInverseConfiguration
    Cliente dtoToEntity(ClienteDTO clienteDTO);
}
/*@Mapper (componentModel = "spring")
public interface ClienteMappers {

	ClienteMappers INSTANCE = Mappers.getMapper(ClienteMappers.class);

    ClienteDTO entityToDto(Cliente cliente);

    @InheritInverseConfiguration
    Cliente dtoToEntity(ClienteDTO clienteDTO);
}*/