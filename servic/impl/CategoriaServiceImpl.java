package com.closetDigit.servic.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.closetDigit.dtos.CategoriaDTO;
import com.closetDigit.entity.Categoria;
import com.closetDigit.maps.CategoriaMapper;
import com.closetDigit.repository.CategoriaRepository;
import com.closetDigit.servic.CategoriaService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository repository;
    private final CategoriaMapper mapper;

    @Override
    public Categoria crearCategoria(CategoriaDTO dto) {
        Categoria cat = mapper.dtoToEntity(dto);
        return repository.save(cat);
    }

    @Override
    public Categoria actualizarCategoria(Long id, CategoriaDTO dto) {
        Categoria existente = repository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Categoría no encontrada"));
        Categoria actualizado = mapper.dtoToEntity(dto);
        actualizado.setIdCategoria(id);
        return repository.save(actualizado);
    }

    @Override
    public void eliminarCategoria(Long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Categoría no encontrada");
        }
        repository.deleteById(id);
    }

    @Override
    public List<Categoria> listarCategorias() {
        return repository.findAll();
    }

    @Override
    public Categoria obtenerPorId(Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Categoría no encontrada"));
    }
}



