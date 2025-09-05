package com.closetDigit.servic;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.closetDigit.dtos.ClienteDTO;
import com.closetDigit.dtos.ResponseDTO;

//interfaces 

public interface ClienteService {
	
	public ResponseEntity<ResponseDTO> crearCliente(ClienteDTO clienteDTO);

    public ResponseEntity<ResponseDTO> actualizarCliente(ClienteDTO clienteDTO);

    public void eliminarCliente(Long id);

    public ResponseEntity<ClienteDTO> obtenerClientePorId(Integer idCliente);

    public ResponseEntity<ResponseDTO> listarClientes();

	public ResponseEntity<ClienteDTO> obtenerClientePorId(Long id);

	void eliminarCliente(Integer idCliente);
	



	ResponseEntity<ResponseDTO> actualizarcliente(Long id, ClienteDTO clienteDTO);

	ResponseEntity<ResponseDTO> eliminarCliente1(Long idCliente);

	void eliminarUsuario(Integer id_usuario);

	ResponseEntity<ResponseDTO> listarClientes1();



	List<ClienteDTO> listarclientes();

	




}
