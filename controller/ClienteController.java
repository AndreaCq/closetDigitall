package com.closetDigit.controller;





import java.net.URI;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.closetDigit.dtos.ClienteDTO;
import com.closetDigit.dtos.ResponseDTO;
import com.closetDigit.entity.Cliente;
import com.closetDigit.repository.ClienteRepository;
import com.closetDigit.servic.ClienteService;

import lombok.RequiredArgsConstructor;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/clientes")
@RequiredArgsConstructor
public class ClienteController {
	
	private final ClienteService clienteService;
 
	
	@PostMapping("/crear")
	public ResponseEntity<Cliente> crearUsuario(@RequestBody Cliente cliente) {
	    Cliente nuevoCliente = clienteService.crearUsuario(cliente);
	    URI location = ServletUriComponentsBuilder.fromCurrentRequest()
	                    .path("/{id}")
	                    .buildAndExpand(nuevoCliente.getIdUsuario())
	                    .toUri();
	    return ResponseEntity.created(location).body(nuevoCliente);
	}
	
	
	
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> eliminarUsuario(@PathVariable Long id) {
	    try {
	        clienteService.eliminarUsuario(id);
	        return ResponseEntity.ok("Usuario eliminado correctamente");
	    } catch (IllegalArgumentException e) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	    }
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> actualizarUsuario(@PathVariable Long id, @RequestBody Cliente clienteActualizado) {
	    try {
	        Cliente cliente = clienteService.actualizarUsuario(id, clienteActualizado);
	        return ResponseEntity.ok(cliente); // Devuelve el cliente actualizado con código 200
	    } catch (IllegalArgumentException e) {
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage()); // Error como "El correo ya está registrado"
	    }
	}
	
	@GetMapping
	public ResponseEntity<List<Cliente>> listarUsuarios() {
	    List<Cliente> usuarios = clienteService.listarUsuarios();
	    return ResponseEntity.ok(usuarios);
	}

	
	
	
 
    @GetMapping("/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("El endpoint funciona");
    }

}




