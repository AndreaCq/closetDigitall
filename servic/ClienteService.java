package com.closetDigit.servic;



import java.util.List;

import org.springframework.http.ResponseEntity;

import com.closetDigit.dtos.ClienteDTO;
import com.closetDigit.dtos.ResponseDTO;
import com.closetDigit.entity.Cliente;




public interface ClienteService {
	
	


	


	


	Cliente crearUsuario(Cliente cliente);


	


	Cliente actualizarUsuario(Long id, Cliente clienteActualizado);


	void eliminarUsuario(Long id);





	ResponseEntity<ResponseDTO> crearCliente(ClienteDTO clienteDTO);

	List<Cliente> listarUsuarios();


	



	


	

}