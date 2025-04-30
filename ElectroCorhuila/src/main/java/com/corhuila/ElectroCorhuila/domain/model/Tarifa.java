package com.corhuila.ElectroCorhuila.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Data
public class Tarifa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double tarifaBase;

    @OneToMany(mappedBy = "tarifa")
    @JsonIgnoreProperties("tarifa")
    private List<Usuario> usuarios;

}
