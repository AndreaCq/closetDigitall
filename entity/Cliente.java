package com.closetDigit.entity;

	
	
	import java.util.Date;

	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.Table;
	



		@Entity
		@Table(name = "cliente")  // Especifica la tabla en la base de datos
		public class Cliente {

		    @Id
		    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Generación automática del ID con autoincremento
		    @Column(name = "id_cliente")  // Mapear con la columna 'id_cliente'
		    private Long idCliente;

		    @Column(name = "nombre", nullable = false, length = 100)  // 'nombre' no puede ser nulo y tiene longitud de 100
		    private String nombre;

		    @Column(name = "apellido", nullable = false, length = 100)  // 'apellido' no puede ser nulo y tiene longitud de 100
		    private String apellido;

		    @Column(name = "email", nullable = false, unique = true, length = 100)  // 'email' es único y no nulo
		    private String email;

		    @Column(name = "telefono", nullable = false, length = 20)  // 'telefono' no puede ser nulo y tiene longitud de 20
		    private String telefono;

		    @Column(name = "direccion", nullable = false, length = 255)  // 'direccion' no puede ser nula y tiene longitud de 255
		    private String direccion;

		    

			
		// Constructor vacío requerido por JPA
	    public Cliente() {}

	    // Constructor con todos los campos
	    public Cliente(Long idCliente, String nombre, String apellido, String email, String telefono, String direccion, Date fechaRegistro) {
	        this.idCliente = idCliente;
	        this.nombre = nombre;
	        this.apellido = apellido;
	        this.email = email;
	        this.telefono = telefono;
	        this.direccion = direccion;
	        
	    }

	    // Getters y Setters
	    public Long getIdCliente() {
	        return idCliente;
	    }

	    public void setIdCliente(Long idCliente) {
	        this.idCliente = idCliente;
	    }

	    public String getNombre() {
	        return nombre;
	    }

	    public void setNombre(String nombre) {
	        this.nombre = nombre;
	    }

	    public String getApellido() {
	        return apellido;
	    }

	    public void setApellido(String apellido) {
	        this.apellido = apellido;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public String getTelefono() {
	        return telefono;
	    }

	    public void setTelefono(String telefono) {
	        this.telefono = telefono;
	    }

	    public String getDireccion() {
	        return direccion;
	    }

	    public void setDireccion(String direccion) {
	        this.direccion = direccion;
	    }

	    

	    // Método toString (opcional, útil para depuración)
	    @Override
	    public String toString() {
	        return "Cliente{" +
	                "idCliente=" + idCliente +
	                ", nombre='" + nombre + '\'' +
	                ", apellido='" + apellido + '\'' +
	                ", email='" + email + '\'' +
	                ", telefono='" + telefono + '\'' +
	                ", direccion='" + direccion + '\'' +
	                
	                '}';
	    }

		
		}

		



