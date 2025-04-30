package com.corhuila.ElectroCorhuila.domain.repository;

import com.corhuila.ElectroCorhuila.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
