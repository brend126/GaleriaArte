package com.uch.GaleriaArte.controller;

import com.uch.GaleriaArte.entity.Cliente;
import com.uch.GaleriaArte.entity.Participacion;
import com.uch.GaleriaArte.service.ClienteService;
import com.uch.GaleriaArte.service.ParticipacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/participaciones")
public class ParticipacionController {

    @Autowired
    private ParticipacionService participacionService;

    @GetMapping("/findAllParticipaciones")
    public List<Participacion> findAllParticipaciones() {
        return participacionService.findAllParticipaciones();
    }

    @PostMapping("/saveParticipacion")
    public Participacion saveParticipacion(@RequestBody Participacion participacion) {
        return participacionService.saveParticipacion(participacion);
    }

    @PostMapping("/{participacionId}/clientes/{clienteId}")
    public ResponseEntity<Participacion> agregarCliente(
            @PathVariable Long participacionId,
            @PathVariable Long clienteId
    ) {
        Participacion participacion = participacionService.agregarCliente(participacionId, clienteId);
        if (participacion == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(participacion);
    }

    @PutMapping("/updateParticipacion/{id}")
    public Participacion updateParticipacion(@PathVariable Long id, @RequestBody Participacion participacion) {
        return participacionService.updateParticipacion(id, participacion);
    }

    @DeleteMapping("/deleteParticipacion/{id}")
    public String deleteParticipacion(@PathVariable Long id) {
        participacionService.deleteParticipacion(id);
        return "Su registro ha sido eliminado correctamente";
    }

    @GetMapping("/{participacionId}/clientes")
    public ResponseEntity<List<Cliente>> findAllClientesByParticipacion(@PathVariable Long participacionId) {
        Participacion participacion = participacionService.findById(participacionId);
        if (participacion == null) {
            return ResponseEntity.notFound().build();
        }
        List<Cliente> clientes = new ArrayList<>(participacion.getClientes());
        return ResponseEntity.ok(clientes);
    }
}

