package com.closetDigit.servic;

import com.closetDigit.dtos.RegistrarUsuarioDTO;
import com.closetDigit.entity.RegistrarUsuario;

public interface RegistrarUsuarioService {
	
	 RegistrarUsuario registrarUsuario(RegistrarUsuarioDTO dto);
	}


