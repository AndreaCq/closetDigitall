package com.closetDigit.service.Impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.closetDigit.dtos.ClienteDTO;
import com.closetDigit.dtos.ResponseDTO;
import com.closetDigit.entity.Cliente;
import com.closetDigit.maps.ClienteMappers;
import com.closetDigit.repository.ClienteRepository;
import com.closetDigit.servic.ClienteService;

import lombok.RequiredArgsConstructor;

//servicios 

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository; // Asegúrate de tener este repositorio creado
    private final ClienteMappers clienteMapper;

    @Override
    public ResponseEntity<ResponseDTO> crearCliente(ClienteDTO clienteDTO) {
        Cliente cliente = clienteMapper.dtoToEntity(clienteDTO);
        // No seteamos fechaRegistro, se llena automáticamente en la base de datos
        Cliente clienteGuardado = clienteRepository.save(cliente);
        ClienteDTO respuestaDTO = clienteMapper.entityToDto(clienteGuardado);
        
        ResponseDTO response = new ResponseDTO("Cliente creado exitosamente", true, respuestaDTO);
        return ResponseEntity.ok(response);
    }
    
    @Override
    public ResponseEntity<ResponseDTO> actualizarcliente (Long id, ClienteDTO clienteDTO) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);

        if (clienteOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ResponseDTO("Cliente no encontrado con ID: " + id, false, null));
        }

        Cliente clienteExistente = clienteOptional.get();

        // Actualiza los campos (excepto ID y fechaRegistro)
        clienteExistente.setNombre(clienteDTO.getNombre());
        clienteExistente.setApellido(clienteDTO.getApellido());
        clienteExistente.setEmail(clienteDTO.getEmail());
        clienteExistente.setTelefono(clienteDTO.getTelefono());
        clienteExistente.setDireccion(clienteDTO.getDireccion());

        Cliente clienteActualizado = clienteRepository.save(clienteExistente);
        ClienteDTO clienteActualizadoDTO = clienteMapper.entityToDto(clienteActualizado);

        ResponseDTO response = new ResponseDTO("Cliente actualizado exitosamente", true, clienteActualizadoDTO);
        return ResponseEntity.ok(response);
    }
    
    @Override
    public ResponseEntity<ResponseDTO> eliminarCliente1(Long idCliente) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(idCliente);
        
        if (clienteOptional.isPresent()) {
            clienteRepository.deleteById(idCliente);
            return ResponseEntity.ok(new ResponseDTO("Cliente eliminado exitosamente", true, null));
        } else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(new ResponseDTO("Cliente no encontrado con ID: " + idCliente, false, null));
        }
    }
        
        
    @Override
    public ResponseEntity<ResponseDTO> listarClientes1() {
        List<Cliente> listaClientes = clienteRepository.findAll();
        List<ClienteDTO> listaClientesDTO = listaClientes.stream()
            .map(clienteMapper::entityToDto)
            .collect(Collectors.toList());

        ResponseDTO response = new ResponseDTO("Lista de clientes obtenida correctamente", true, listaClientesDTO);
        return ResponseEntity.ok(response);
    }


    

    




	@Override
	public ResponseEntity<ResponseDTO> actualizarCliente(ClienteDTO clienteDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public ResponseEntity<ClienteDTO> obtenerClientePorId(Integer idCliente) {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public ResponseEntity<ClienteDTO> obtenerClientePorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarCliente(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarCliente(Integer idCliente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarUsuario(Integer id_usuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ResponseEntity<ResponseDTO> listarClientes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ClienteDTO> listarclientes() {
		// TODO Auto-generated method stub
		return null;
	}

	


	


    // Otros métodos aún pueden quedar vacíos si no los usas
}
	