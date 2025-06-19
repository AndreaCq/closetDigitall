package com.closetDigit.maps;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.closetDigit.dtos.RegistrarUsuarioDTO;
import com.closetDigit.entity.RegistrarUsuario;

@Mapper(componentModel = "spring")
public interface RegistrarUsuarioMappers {
	
	 RegistrarUsuarioMappers INSTANCE = Mappers.getMapper(RegistrarUsuarioMappers.class);

	    RegistrarUsuarioDTO entityToDto(RegistrarUsuario usuario);

	    @InheritInverseConfiguration
	    RegistrarUsuario dtoToEntity(RegistrarUsuarioDTO usuarioDTO);
	}


