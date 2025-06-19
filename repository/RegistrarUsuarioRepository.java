package com.closetDigit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.closetDigit.entity.RegistrarUsuario;

public interface RegistrarUsuarioRepository extends JpaRepository<RegistrarUsuario, Long> {
	 boolean existsByCorreo(String correo);

}
