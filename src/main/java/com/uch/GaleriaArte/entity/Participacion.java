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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String tipoActividad;
    private LocalDate fechaActividad;

    @ManyToMany
    @JoinTable(
            name = "participacion_obra_de_arte",
            joinColumns = @JoinColumn(name = "participacion_id"),
            inverseJoinColumns = @JoinColumn(name = "obra_de_arte_id")
    )
    private Set<ObraDeArte> obrasDeArte = new HashSet<>();


}
