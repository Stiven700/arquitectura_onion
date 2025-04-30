package com.corhuila.ElectroCorhuila.application.service;

import com.corhuila.ElectroCorhuila.domain.model.Tarifa;
import com.corhuila.ElectroCorhuila.domain.repository.TarifaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarifaService {

    @Autowired
    private TarifaRepository tarifaRepository;

    // Obtener todas las tarifas
    public List<Tarifa> obtenerTodasLasTarifas() {
        return tarifaRepository.findAll();
    }

    // Obtener tarifa por ID
    public Tarifa obtenerTarifaPorId(Long id) {
        return tarifaRepository.findById(id).orElse(null);
    }

    // Obtener tarifa según el estrato
    public Tarifa obtenerTarifaPorEstrato(String estrato) {
        // Aquí implementamos la lógica de tarifas por estrato
        switch (estrato) {
            case "1":
                return tarifaRepository.findByTarifaBase(100.0);  // Tarifa base para estrato 1
            case "2":
                return tarifaRepository.findByTarifaBase(120.0);  // Tarifa base para estrato 2
            case "3":
                return tarifaRepository.findByTarifaBase(150.0);  // Tarifa base para estrato 3
            case "4":
                return tarifaRepository.findByTarifaBase(180.0);  // Tarifa base para estrato 3
            case "5":
                return tarifaRepository.findByTarifaBase(200.0);  // Tarifa base para estrato 3
            case "6":
                return tarifaRepository.findByTarifaBase(250.0);  // Tarifa base para estrato 3

            default:
                return null; // Si no hay tarifa para el estrato
        }
    }

    // Crear una nueva tarifa
    public Tarifa crearTarifa(Tarifa tarifa) {
        return tarifaRepository.save(tarifa);
    }
}

