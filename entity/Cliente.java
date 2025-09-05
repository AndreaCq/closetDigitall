package com.closetDigit.entity;

import java.time.LocalDate;
import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "usuario")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    @JsonProperty("id_usuario")  // Cambiado aquí
    private Long idUsuario;

    @Column(name = "nombre", nullable = false, length = 100)
    @JsonProperty("nombre")
    private String nombre;

    @Column(name = "correo", nullable = false, unique = true, length = 100)
    @JsonProperty("correo")
    private String correo;

    @Column(name = "password", nullable = false, length = 255)
    @JsonProperty("password")
    private String password;

    @Column(name = "fecha_registro", updatable = false)
    @CreationTimestamp
    @JsonProperty("fecha_registro")  // Cambiado aquí
    private LocalDate fechaRegistro;

    @Column(name = "estado")
    @JsonProperty("estado")
    private Boolean estado = true;

    public Cliente() {}

    public Cliente(String nombre, String correo, String password, Boolean estado) {
        this.nombre = nombre;
        this.correo = correo;
        this.password = password;
        if (estado != null) {
            this.estado = estado;
        }
    }

    // Getters y Setters

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "idUsuario=" + idUsuario +
                ", nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", password='" + password + '\'' +
                ", fechaRegistro=" + fechaRegistro +
                ", estado=" + estado +
                '}';
    }
}
