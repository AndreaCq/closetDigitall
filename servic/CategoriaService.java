package com.closetDigit.servic;

import java.util.List;

import com.closetDigit.dtos.CategoriaDTO;
import com.closetDigit.entity.Categoria;

public interface CategoriaService {
    Categoria crearCategoria(CategoriaDTO dto);
    Categoria actualizarCategoria(Long id, CategoriaDTO dto);
    void eliminarCategoria(Long id);
    List<Categoria> listarCategorias();
    Categoria obtenerPorId(Long id);
}
