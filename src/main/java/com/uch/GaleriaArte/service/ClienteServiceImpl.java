package com.uch.GaleriaArte.service;

import com.uch.GaleriaArte.entity.Cliente;
import com.uch.GaleriaArte.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    public Cliente saveCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public List<Cliente> findAllClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente updateCliente(Long id, Cliente cliente) {
        Cliente clienteDb = clienteRepository.findById(id).get();
        if(Objects.nonNull(cliente.getNombre()) && !"".equalsIgnoreCase(cliente.getNombre())){
            clienteDb.setNombre(cliente.getNombre());
        }
        if(Objects.nonNull(cliente.getApellido()) && !"".equalsIgnoreCase(cliente.getApellido())){
            clienteDb.setApellido(cliente.getApellido());
        }
        if(Objects.nonNull(cliente.getDireccion()) && !"".equalsIgnoreCase(cliente.getDireccion())){
            clienteDb.setDireccion(cliente.getDireccion());
        }
        if(Objects.nonNull(cliente.getTelefono()) && !"".equalsIgnoreCase(cliente.getTelefono())){
            clienteDb.setTelefono(cliente.getTelefono());
        }
        if(Objects.nonNull(cliente.getCorreoElectronico()) && !"".equalsIgnoreCase(cliente.getCorreoElectronico())){
            clienteDb.setCorreoElectronico(cliente.getCorreoElectronico());
        }
        if(Objects.nonNull(cliente.getFechaNacimiento()) && !"".equalsIgnoreCase(String.valueOf(cliente.getFechaNacimiento()))){
            clienteDb.setFechaNacimiento(cliente.getFechaNacimiento());
        }
        return clienteRepository.save(clienteDb);
    }

    @Override
    public void deleteCliente(Long id) {
        clienteRepository.deleteById(id);
    }

}
