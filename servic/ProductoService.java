package com.closetDigit.servic;

import java.util.List;

import com.closetDigit.dtos.ProductoDTO;
import com.closetDigit.entity.Producto;

public interface ProductoService {
	Producto crearProducto(ProductoDTO dto);
    Producto actualizarProducto(Long id, ProductoDTO dto);
    void eliminarProducto(Long id);
    List<Producto> listarProductos();

}
