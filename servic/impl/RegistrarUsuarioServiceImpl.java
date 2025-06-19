package com.closetDigit.servic.impl;

import org.springframework.stereotype.Service;

import com.closetDigit.dtos.RegistrarUsuarioDTO;
import com.closetDigit.entity.RegistrarUsuario;
import com.closetDigit.repository.RegistrarUsuarioRepository;
import com.closetDigit.servic.RegistrarUsuarioService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RegistrarUsuarioServiceImpl implements RegistrarUsuarioService{
	
	 private final RegistrarUsuarioRepository repository;

	    @Override
	    public RegistrarUsuario registrarUsuario(RegistrarUsuarioDTO dto) {
	        if (repository.existsByCorreo(dto.getCorreo())) {
	            throw new IllegalArgumentException("El correo ya está registrado.");
	        }

	        RegistrarUsuario nuevo = new RegistrarUsuario();
	        nuevo.setNombreUsuario(dto.getNombreUsuario());
	        nuevo.setCorreo(dto.getCorreo());
	        nuevo.setContrasena(dto.getContrasena()); // puedes cifrar aquí si deseas
	        nuevo.setRol(dto.getRol());
	        nuevo.setActivo(dto.getActivo() != null ? dto.getActivo() : true);

	        return repository.save(nuevo);
	    }
	}


