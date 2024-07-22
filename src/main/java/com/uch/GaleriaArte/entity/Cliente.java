package com.uch.GaleriaArte.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "clientes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cliente_id")
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
    @ManyToMany (cascade = CascadeType.ALL)
    @JoinTable(
            name = "cliente_participacion",
            joinColumns = @JoinColumn(name = "cliente_id", referencedColumnName = "cliente_id"),
            inverseJoinColumns = @JoinColumn(name = "participacion_id", referencedColumnName = "participacion_id")
    )
    @JsonBackReference
    private Set<Participacion> participaciones = new HashSet<>();

}
