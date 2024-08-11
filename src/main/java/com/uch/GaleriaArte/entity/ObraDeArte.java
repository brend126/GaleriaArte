package com.uch.GaleriaArte.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "obrasDeArte")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ObraDeArte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombreArtista;
    private String tipoDeObra;
    private String movimientoArtistico;

    @ManyToMany(mappedBy = "obrasDeArte")
    private Set<Participacion> participaciones = new HashSet<>();
}
