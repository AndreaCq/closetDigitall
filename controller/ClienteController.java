package com.closetDigit.controller;

import java.util.List;

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

import com.closetDigit.dtos.ClienteDTO;
import com.closetDigit.dtos.ResponseDTO;
import com.closetDigit.servic.ClienteService;

import lombok.RequiredArgsConstructor;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/clientes")
@RequiredArgsConstructor
public class ClienteController {
	
	private final ClienteService clienteService;

    @PostMapping("/crear/cliente")
    public ResponseEntity<ResponseDTO> crearCliente(@RequestBody ClienteDTO clienteDTO) {
        return clienteService.crearCliente(clienteDTO);
    }
    @GetMapping("/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("El endpoint funciona");
    }


    @PutMapping("/{id}")
    public ResponseEntity<ResponseDTO> actualizarCliente(@PathVariable Long id, @RequestBody ClienteDTO clienteDTO) {
        return clienteService.actualizarcliente(id, clienteDTO);
    }

   

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> obtenerCliente(@PathVariable Long id) {
        return clienteService.obtenerClientePorId(id);
    }

    @GetMapping("/listar")
    public ResponseEntity<ResponseDTO> listarClientes() {
        return clienteService.listarClientes1();
    }
   
    
   

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDTO> eliminarCliente1(@PathVariable("id") Long id) {
        return clienteService.eliminarCliente1(id);
    }

}




