package com.closetDigit.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.closetDigit.dtos.RegistrarUsuarioDTO;
import com.closetDigit.entity.RegistrarUsuario;
import com.closetDigit.servic.RegistrarUsuarioService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/registro")
@RequiredArgsConstructor
public class RegistrarUsuarioController {
	
	private final RegistrarUsuarioService service;

    @PostMapping
    public ResponseEntity<?> registrar(@RequestBody RegistrarUsuarioDTO dto) {
        try {
            RegistrarUsuario registrado = service.registrarUsuario(dto);
            return ResponseEntity.status(201).body(registrado);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}


