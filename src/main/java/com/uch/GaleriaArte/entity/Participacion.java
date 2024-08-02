package com.uch.GaleriaArte.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

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
    private String tipoActividad;
    private LocalDate fechaActividad;



}
