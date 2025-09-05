package com.closetDigit.dtos;

public class CategoriaDTO {
	
	 private Long idCategoria;
	    private String nombre;
	    private String descripcion;
	    private Boolean estado;

	    // Getters y setters
	    public Long getIdCategoria() {
	        return idCategoria;
	    }
	    public void setIdCategoria(Long idCategoria) {
	        this.idCategoria = idCategoria;
	    }
	    public String getNombre() {
	        return nombre;
	    }
	    public void setNombre(String nombre) {
	        this.nombre = nombre;
	    }
	    public String getDescripcion() {
	        return descripcion;
	    }
	    public void setDescripcion(String descripcion) {
	        this.descripcion = descripcion;
	    }
	    public Boolean getEstado() {
	        return estado;
	    }
	    public void setEstado(Boolean estado) {
	        this.estado = estado;
	    }
	


}
