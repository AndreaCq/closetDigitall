package com.closetDigit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.closetDigit.entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{

}
