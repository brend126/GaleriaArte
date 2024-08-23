package com.uch.GaleriaArte.controller;

import com.uch.GaleriaArte.entity.Preferencia;
import com.uch.GaleriaArte.service.PreferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PreferenciaController {
    @Autowired
    PreferenciaService preferenciaService;

    @GetMapping("/findAllPreferencias")
    public List<Preferencia> findAllPreferencias(){
        return preferenciaService.findAllPreferencias();
    }

    @PostMapping("/savePreferencia")
    public Preferencia savePreferencia(@RequestBody Preferencia preferencia){
        return preferenciaService.savePreferencia(preferencia);
    }

    @PutMapping("/updatePreferencia/{id}")
    public Preferencia updatePreferencia(@PathVariable Long id, @RequestBody Preferencia preferencia){
        return preferenciaService.updatePreferencia(id,preferencia);
    }

    @DeleteMapping("/deletePreferencia/{id}")
    public String deletePreferencia(@PathVariable Long id){
        preferenciaService.deletePreferencia(id);
        return "Su registro ha sido eliminado correctamente";
    }
}
