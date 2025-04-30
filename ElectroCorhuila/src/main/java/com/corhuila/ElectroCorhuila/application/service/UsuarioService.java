package com.corhuila.ElectroCorhuila.application.service;

import com.corhuila.ElectroCorhuila.domain.model.Usuario;
import com.corhuila.ElectroCorhuila.domain.model.Tarifa;
import com.corhuila.ElectroCorhuila.domain.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TarifaService tarifaService;

    // Guardar usuario con tarifa
    public Usuario guardar(Usuario usuario) {
        // Obtener la tarifa correspondiente según el estrato
        Tarifa tarifa = tarifaService.obtenerTarifaPorEstrato(usuario.getEstrato());

        if (tarifa != null) {
            usuario.setTarifa(tarifa);  // Asignar la tarifa al usuario
        }

        return usuarioRepository.save(usuario);  // Guardar al usuario
    }

    // Obtener todos los usuarios
    public List<Usuario> obtenerUsuarios() {
        return usuarioRepository.findAll();
    }

    // Obtener usuario por ID
    public Usuario obtenerUsuarioPorId(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }
}
