package com.uch.GaleriaArte.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "participaciones")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Participacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "participacion_id")
    private Long id;

    private String tipoActividad;
    private LocalDate fechaActividad;

    @ManyToMany (cascade = CascadeType.ALL)
    @JoinTable(
            name = "cliente_participacion",
            joinColumns = @JoinColumn(name = "participacion_id", referencedColumnName = "participacion_id"),
            inverseJoinColumns = @JoinColumn(name = "cliente_id", referencedColumnName = "cliente_id")
    )
    private Set<Cliente> clientes = new HashSet<>();

}
