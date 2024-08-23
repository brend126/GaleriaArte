package com.uch.GaleriaArte.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "preferencias")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Preferencia {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String tiposDeArte;
    private String artistasFavoritos;
    private String estilosFavoritos;

    @OneToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    @JsonBackReference
    private Cliente cliente;
}
