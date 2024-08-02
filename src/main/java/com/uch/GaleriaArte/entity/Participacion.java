package com.uch.GaleriaArte.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;


import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "participaciones")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Participacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "tipoActividad", nullable = false)
    private String tipoActividad;
    @Column(name = "fechaActividad", nullable = false)
    private LocalDate fechaActividad;

    @ManyToMany (cascade = CascadeType.ALL)
    @JoinTable(
            name = "cliente_participacion",
            joinColumns = @JoinColumn(name = "participacion_id"),
            inverseJoinColumns = @JoinColumn(name = "cliente_id")
    )
    private List<Cliente> clientes;

}
