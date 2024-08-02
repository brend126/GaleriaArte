package com.uch.GaleriaArte.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Setter
@Getter
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
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "apellido", nullable = false)
    private String apellido;
    @Column(name = "direccion", nullable = false)
    private String direccion;
    @Column(name = "telefono", nullable = false)
    private String telefono;
    @Column(name = "correoElectronico", nullable = false)
    private String correoElectronico;
    @Column(name = "fechaNacimiento", nullable = false)
    private LocalDate fechaNacimiento;

    @OneToMany(mappedBy = "cliente")
    private List<Compra> compras;
    @OneToOne(mappedBy = "cliente")
    private Preferencia preferencia;
    @ManyToMany (cascade = CascadeType.ALL)
    @JoinTable(
            name = "cliente_participacion",
            joinColumns = @JoinColumn(name = "cliente_id"),
            inverseJoinColumns = @JoinColumn(name = "participacion_id")
    )
    private List<Participacion> participacions;

    public Collection<Participacion> getParticipaciones() {
    }
}
