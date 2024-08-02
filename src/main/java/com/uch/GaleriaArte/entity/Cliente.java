package com.uch.GaleriaArte.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Entity;

import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name = "clientes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;
    private String correoElectronico;
    private LocalDate fechaNacimiento;

    @OneToMany(mappedBy = "cliente")
    private List<Compra> compras;
    @OneToOne(mappedBy = "cliente")
    private Preferencia preferencia;

}
