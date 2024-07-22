package com.uch.GaleriaArte.controller;

import com.uch.GaleriaArte.entity.Cliente;
import com.uch.GaleriaArte.repository.ClienteRepository;
import com.uch.GaleriaArte.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;


    @GetMapping("/{id}")
    public ResponseEntity<Cliente> obtenerClientePorId(@PathVariable Long id) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow();

        if(cliente != null){
            return new ResponseEntity<Cliente>(clienteRepository.findById(id).orElseThrow(), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }




   /* @PostMapping("/saveCliente")
    public Cliente saveCliente(@RequestBody Cliente cliente) {
        return clienteService.saveCliente(cliente);
    }

    @PostMapping("/{clienteId}/participaciones/{participacionId}")
    public ResponseEntity<Cliente> agregarParticipacion(
            @PathVariable Long clienteId,
            @PathVariable Long participacionId
    ) {
        Cliente cliente = clienteService.agregarParticipacion(clienteId, participacionId);
        if (cliente == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cliente);
    }

    @PutMapping("/updateCliente/{id}")
    public Cliente updateCliente(@PathVariable Long id, @RequestBody Cliente cliente){
        return clienteService.updateCliente(id, cliente);
    }

    @DeleteMapping("/deleteCliente/{id}")
    public String deleteCliente(@PathVariable Long id){
        clienteService.deleteCliente(id);
        return "Su registro ha sido eliminado correctamente";
    }

}
