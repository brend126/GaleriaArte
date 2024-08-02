package com.uch.GaleriaArte.controller;

import com.uch.GaleriaArte.entity.Cliente;
import com.uch.GaleriaArte.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @GetMapping("/findAllClientes")
    public List<Cliente> findAllClientes() {
        return clienteService.findAllClientes();
    }

    @PostMapping("/saveCliente")
    public Cliente saveCliente(@RequestBody Cliente cliente) {
        return clienteService.saveCliente(cliente);
    }


    @PutMapping("/updateCliente/{id}")
    public Cliente updateCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        return clienteService.updateCliente(id, cliente);
    }

    @DeleteMapping("/deleteCliente/{id}")
    public String deleteCliente(@PathVariable Long id) {
        clienteService.deleteCliente(id);
        return "Su registro ha sido eliminado correctamente";
    }
}

