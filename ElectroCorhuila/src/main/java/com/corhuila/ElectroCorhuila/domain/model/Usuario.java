            package com.corhuila.ElectroCorhuila.domain.model;

            import com.fasterxml.jackson.annotation.JsonBackReference;
            import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
            import jakarta.persistence.*;
            import lombok.*;

            @Entity
            @Data // Lombok generará automáticamente los métodos
            public class Usuario {

                @Id
                @GeneratedValue(strategy = GenerationType.IDENTITY)
                private Long id;
                private String nombre;
                private String estrato;

                @ManyToOne(fetch = FetchType.EAGER)
                @JoinColumn(name = "id_tarifa")
                @JsonIgnoreProperties("usuarios") // evita recursividad infinita
                private Tarifa tarifa;

            }
