package com.corhuila.ElectroCorhuila.api.controller;

import com.corhuila.ElectroCorhuila.application.service.TarifaService;
import com.corhuila.ElectroCorhuila.domain.model.Tarifa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarifas")
public class TarifaController {

    @Autowired
    private TarifaService tarifaService;

    // Crear una nueva tarifa
    @PostMapping
    public Tarifa crearTarifa(@RequestBody Tarifa tarifa) {
        return tarifaService.crearTarifa(tarifa);
    }

    // Obtener todas las tarifas
    @GetMapping
    public List<Tarifa> obtenerTodasLasTarifas() {
        return tarifaService.obtenerTodasLasTarifas();
    }

    // Obtener tarifa por ID
    @GetMapping("/{id}")
    public Tarifa obtenerTarifaPorId(@PathVariable Long id) {
        return tarifaService.obtenerTarifaPorId(id);
    }
}

