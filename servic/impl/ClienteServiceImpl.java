package com.closetDigit.servic.impl;

import java.security.MessageDigest;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.closetDigit.dtos.ClienteDTO;
import com.closetDigit.dtos.ResponseDTO;
import com.closetDigit.entity.Cliente;
import com.closetDigit.repository.ClienteRepository;
import com.closetDigit.servic.ClienteService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;
    

   


    @Override
    public Cliente crearUsuario(Cliente cliente) {
        if (cliente.getCorreo() == null || cliente.getCorreo().isEmpty()) {
            throw new IllegalArgumentException("El correo es obligatorio");
        }
        if (cliente.getNombre() == null || cliente.getNombre().isEmpty()) {
            throw new IllegalArgumentException("El nombre es obligatorio");
        }
        if (cliente.getPassword() == null || cliente.getPassword().isEmpty()) {
            throw new IllegalArgumentException("La contraseña es obligatoria");
        }

        if (clienteRepository.existsByCorreo(cliente.getCorreo())) {
            throw new IllegalArgumentException("El correo ya está registrado");
        }

        // Encriptar con SHA-256
        String encodedPassword = sha256(cliente.getPassword());
        cliente.setPassword(encodedPassword);

        return clienteRepository.save(cliente);
    }

    private String sha256(String base) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(base.getBytes("UTF-8"));
            StringBuilder hexString = new StringBuilder();

            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (Exception ex) {
            throw new RuntimeException("Error al encriptar la contraseña", ex);
        }
    }
    
    

    
    @Override
    public Cliente actualizarUsuario(Long id, Cliente clienteActualizado) {
        Cliente existente = clienteRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));

        // Validar si el nuevo correo ya existe en otro usuario
        Optional<Cliente> clienteConMismoCorreo = clienteRepository.findByCorreo(clienteActualizado.getCorreo());
        if (clienteConMismoCorreo.isPresent() && !clienteConMismoCorreo.get().getIdUsuario().equals(id)) {
            throw new IllegalArgumentException("El correo ya está registrado por otro usuario");
        }

        // Actualiza los campos permitidos
        existente.setNombre(clienteActualizado.getNombre());
        existente.setCorreo(clienteActualizado.getCorreo());
        existente.setPassword(clienteActualizado.getPassword());
        existente.setEstado(clienteActualizado.getEstado());
        // No olvides manejar fecha_registro si aplica

        return clienteRepository.save(existente);
    }


    
    @Override
    public void eliminarUsuario(Long id) {
        Cliente cliente = clienteRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));
        clienteRepository.delete(cliente);
    }
    @Override
    public List<Cliente> listarUsuarios() {
        return clienteRepository.findByEstadoTrue();
    }


	@Override
	public ResponseEntity<ResponseDTO> crearCliente(ClienteDTO clienteDTO) {
		// TODO Auto-generated method stub
		return null;
	}


	
	


}
