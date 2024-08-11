package com.uch.GaleriaArte.controller;

import com.uch.GaleriaArte.entity.Participacion;
import com.uch.GaleriaArte.service.ParticipacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
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

    @PutMapping("/updateParticipacion/{id}")
    public Participacion updateParticipacion(@PathVariable Long id, @RequestBody Participacion participacion) {
        return participacionService.updateParticipacion(id, participacion);
    }

    @DeleteMapping("/deleteParticipacion/{id}")
    public String deleteParticipacion(@PathVariable Long id) {
        participacionService.deleteParticipacion(id);
        return "Su registro ha sido eliminado correctamente";
    }

    @PutMapping("/participaciones/{participacionId}/obrasDeArte/{obraDeArteId}")
    public Participacion addObraDeArteToParticipacion(
            @PathVariable Long participacionId,
            @PathVariable Long obraDeArteId) {
        return participacionService.addObraDeArteToParticipacion(participacionId, obraDeArteId);
    }
}




