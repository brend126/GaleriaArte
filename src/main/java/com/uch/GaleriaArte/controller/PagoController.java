package com.uch.GaleriaArte.controller;

import com.uch.GaleriaArte.entity.Pago;
import com.uch.GaleriaArte.service.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PagoController {
    @Autowired
    PagoService pagoService;

    @GetMapping("/findAllPagos")
    public List<Pago> findAllPagos() {
        return pagoService.findAllPagos();
    }

    @PostMapping("/savePago")
    public Pago savePago(@RequestBody Pago pago) {
        return pagoService.savePago(pago);
    }

    @PutMapping("/updatePago/{id}")
    public Pago updatePago(@PathVariable Long id, @RequestBody Pago pago) {
        return pagoService.updatePago(id, pago);
    }

    @DeleteMapping("/deletePago/{id}")
    public String deletePago(@PathVariable Long id) {
        pagoService.deletePago(id);
        return "Su registro ha sido eliminado correctamente";
    }
}
