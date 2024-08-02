package com.uch.GaleriaArte.service;

import com.uch.GaleriaArte.entity.Cliente;

import java.util.List;
import java.util.Set;

public interface ClienteService {
    List<Cliente> findAllClientes();
    Cliente saveCliente(Cliente cliente);
    Cliente updateCliente(Long id, Cliente cliente);
    void deleteCliente(Long id);

    Cliente agregarParticipacion(Long clienteId, Long participacionId);

    Cliente findById(Long id);
}

