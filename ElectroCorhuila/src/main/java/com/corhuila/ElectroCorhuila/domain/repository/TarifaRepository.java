package com.corhuila.ElectroCorhuila.domain.repository;

import com.corhuila.ElectroCorhuila.domain.model.Tarifa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarifaRepository extends JpaRepository<Tarifa, Long> {
    Tarifa findByTarifaBase(Double tarifaBase); // Método adicional para buscar por tarifaBase
}
