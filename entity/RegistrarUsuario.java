package com.closetDigit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "registrar_usuario")

public class RegistrarUsuario {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id_usuario")
	    private Long idUsuario;

	    @Column(name = "nombre_usuario", nullable = false, length = 100)
	    private String nombreUsuario;

	    @Column(nullable = false, length = 100, unique = true)
	    private String correo;

	    @Column(name = "contrasena", nullable = false, length = 100)
	    private String contrasena;

	    @Column(nullable = false, length = 50)
	    private String rol;

	    @Column(nullable = false)
	    private Boolean activo;

	    // --- Getters y Setters ---

	    public Long getIdUsuario() {
	        return idUsuario;
	    }

	    public void setIdUsuario(Long idUsuario) {
	        this.idUsuario = idUsuario;
	    }

	    public String getNombreUsuario() {
	        return nombreUsuario;
	    }

	    public void setNombreUsuario(String nombreUsuario) {
	        this.nombreUsuario = nombreUsuario;
	    }

	    public String getCorreo() {
	        return correo;
	    }

	    public void setCorreo(String correo) {
	        this.correo = correo;
	    }

	    public String getContrasena() {
	        return contrasena;
	    }

	    public void setContrasena(String contrasena) {
	        this.contrasena = contrasena;
	    }

	    public String getRol() {
	        return rol;
	    }

	    public void setRol(String rol) {
	        this.rol = rol;
	    }

	    public Boolean getActivo() {
	        return activo;
	    }

	    public void setActivo(Boolean activo) {
	        this.activo = activo;
	    }
	}


