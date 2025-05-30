package com.closetDigit.conexion;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.closetDigit.repository.ClienteRepository;

@Component
public class TestConexion implements CommandLineRunner {

    private final ClienteRepository usuarioRepository;

    public TestConexion(ClienteRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        long total = usuarioRepository.count();
        System.out.println("✅ Conectado a la base de datos. Total usuarios: " + total);
    }
}
