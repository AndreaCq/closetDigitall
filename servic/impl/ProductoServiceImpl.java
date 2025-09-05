package com.closetDigit.servic.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.closetDigit.dtos.ProductoDTO;
import com.closetDigit.entity.Producto;
import com.closetDigit.maps.ProductoMapper;
import com.closetDigit.repository.ProductoRepository;
import com.closetDigit.servic.ProductoService;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class ProductoServiceImpl implements ProductoService {
	
	
	private final ProductoRepository repository;
    private final ProductoMapper mapper;

    @Override
    public Producto crearProducto(ProductoDTO dto) {
        Producto producto = mapper.dtoToEntity(dto);
        return repository.save(producto);
    }

    @Override
    public Producto actualizarProducto(Long id, ProductoDTO dto) {
        Producto existente = repository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado"));
        Producto actualizado = mapper.dtoToEntity(dto);
        actualizado.setIdProducto(id);
        return repository.save(actualizado);
    }

    @Override
    public void eliminarProducto(Long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Producto no encontrado");
        }
        repository.deleteById(id);
    }

    @Override
    public List<Producto> listarProductos() {
        return repository.findAll();
    }

}
