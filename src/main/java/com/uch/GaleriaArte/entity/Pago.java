package com.uch.GaleriaArte.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pagos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String metodoDePago;
    private String historialDePagos;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    @JsonBackReference
    private Cliente cliente;
}
