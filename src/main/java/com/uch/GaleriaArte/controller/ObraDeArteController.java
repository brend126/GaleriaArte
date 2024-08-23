package com.uch.GaleriaArte.controller;

import com.uch.GaleriaArte.entity.ObraDeArte;
import com.uch.GaleriaArte.service.ObraDeArteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ObraDeArteController {
    @Autowired
    ObraDeArteService obraDeArteService;

    @GetMapping("/findAllObraDeArte")
    public List<ObraDeArte> findAllObraDeArte() {
        return obraDeArteService.findAllObraDeArte();
    }

    @PostMapping("/saveObraDeArte")
    public ObraDeArte saveObraDeArte(@RequestBody ObraDeArte obraDeArte) {
        return obraDeArteService.saveObraDeArte(obraDeArte);
    }


    @PutMapping("/updateObraDeArte/{id}")
    public ObraDeArte updateObraDeArte(@PathVariable Long id, @RequestBody ObraDeArte obraDeArte) {
        return obraDeArteService.updateObraDeArte(id, obraDeArte);
    }

    @DeleteMapping("/deleteObraDeArte/{id}")
    public String deleteObraDeArte(@PathVariable Long id) {
        obraDeArteService.deleteObraDeArte(id);
        return "Su registro ha sido eliminado correctamente";
    }
}
