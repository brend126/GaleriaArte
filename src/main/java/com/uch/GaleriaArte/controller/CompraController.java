package com.uch.GaleriaArte.controller;

import com.uch.GaleriaArte.entity.Compra;
import com.uch.GaleriaArte.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompraController {
    @Autowired
    CompraService compraService;

    @GetMapping("/findAllCompras")
    public List<Compra> findAllCompra(){
        return compraService.findAllCompras();
    }

    @PostMapping("/saveCompra")
    public Compra saveCompra(@RequestBody Compra compra){
        return compraService.saveCompra(compra);
    }

    @PutMapping("/updateCompra/{id}")
    public Compra updateCompra(@PathVariable Long id, @RequestBody Compra compra){
        return compraService.updateCompra(id,compra);
    }

    @DeleteMapping("/deleteCompra/{id}")
    public String deleteCompra(@PathVariable Long id){
        compraService.deleteCompra(id);
        return "Su registro ha sido eliminado correctamente";
    }
}
