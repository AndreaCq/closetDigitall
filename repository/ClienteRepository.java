package com.closetDigit.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.closetDigit.entity.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	boolean existsByCorreo(String correo);

	Optional<Cliente> findByCorreo(String correo);
	List<Cliente> findByEstadoTrue();


}
