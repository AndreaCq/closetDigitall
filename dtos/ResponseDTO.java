package com.closetDigit.dtos;

public class ResponseDTO {
	
	 private String mensaje;
	    private boolean exito;
	    private Object datos;

	    public ResponseDTO() {}

	    public ResponseDTO(String mensaje, boolean exito, Object datos) {
	        this.mensaje = mensaje;
	        this.exito = exito;
	        this.datos = datos;
	    }

	    // Getters y Setters
	    public String getMensaje() { return mensaje; }
	    public void setMensaje(String mensaje) { this.mensaje = mensaje; }

	    public boolean isExito() { return exito; }
	    public void setExito(boolean exito) { this.exito = exito; }

	    public Object getDatos() { return datos; }
	    public void setDatos(Object datos) { this.datos = datos; }
	}



