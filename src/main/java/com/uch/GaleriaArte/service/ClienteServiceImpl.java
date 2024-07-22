package com.uch.GaleriaArte.service;

import com.uch.GaleriaArte.entity.Cliente;
import com.uch.GaleriaArte.entity.Participacion;
import com.uch.GaleriaArte.exception.ResourceNotFoundException;
import com.uch.GaleriaArte.repository.ClienteRepository;
import com.uch.GaleriaArte.repository.ParticipacionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Set;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    private ParticipacionRepository participacionRepository;

    public Cliente saveCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente agregarParticipacion(Long clienteId, Long participacionId) {
        Cliente cliente = clienteRepository.findById(clienteId).orElseThrow(() -> new RuntimeException("Cliente not found"));
        Participacion participacion = participacionRepository.findById(participacionId).orElseThrow(() -> new RuntimeException("Participacion not found"));

        cliente.getParticipaciones().add(participacion);
        participacion.getClientes().add(cliente);

        clienteRepository.save(cliente);
        participacionRepository.save(participacion);

        return cliente;
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
