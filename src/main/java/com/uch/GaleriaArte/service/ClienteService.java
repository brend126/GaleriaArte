package com.uch.GaleriaArte.service;

import com.uch.GaleriaArte.entity.Cliente;

import java.util.List;

public interface ClienteService {
    List<Cliente> findAllClientes();
    Cliente saveCliente(Cliente cliente);
    Cliente updateCliente(Long id, Cliente cliente);
    void deleteCliente(Long id);


}

