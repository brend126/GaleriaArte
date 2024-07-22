package com.uch.GaleriaArte.service;

import com.uch.GaleriaArte.entity.Cliente;
import com.uch.GaleriaArte.entity.Participacion;
import com.uch.GaleriaArte.exception.ResourceNotFoundException;
import com.uch.GaleriaArte.repository.ClienteRepository;
import com.uch.GaleriaArte.repository.ParticipacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;


@Service
public class ParticipacionServiceImpl implements ParticipacionService{

    @Autowired
    ParticipacionRepository participacionRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public Participacion saveParticipacion(Participacion participacion) {
        return participacionRepository.save(participacion);
    }

    public Participacion agregarCliente(Long participacionId, Long clienteId) {
        Participacion participacion = participacionRepository.findById(participacionId).orElseThrow(() -> new RuntimeException("Participacion not found"));
        Cliente cliente = clienteRepository.findById(clienteId).orElseThrow(() -> new RuntimeException("Cliente not found"));

        participacion.getClientes().add(cliente);
        cliente.getParticipaciones().add(participacion);

        participacionRepository.save(participacion);
        clienteRepository.save(cliente);

        return participacion;
    }

    @Override
    public List<Participacion> findAllParticipaciones() {
        return participacionRepository.findAll();
    }


    @Override
    public Participacion updateParticipacion(Long id, Participacion participacion) {
        Participacion participacionDb = participacionRepository.findById(id).get();
        if(Objects.nonNull(participacion.getTipoActividad()) && !"".equalsIgnoreCase(participacion.getTipoActividad())){
            participacionDb.setTipoActividad(participacion.getTipoActividad());
        }
        if(Objects.nonNull(participacion.getFechaActividad()) && !"".equalsIgnoreCase(String.valueOf(participacion.getFechaActividad()))){
            participacionDb.setFechaActividad(participacion.getFechaActividad());
        }
        return participacionRepository.save(participacionDb);
    }

    @Override
    public void deleteParticipacion(Long id) {
        participacionRepository.deleteById(id);

    }
    public Participacion findById(Long id) {
        return participacionRepository.findById(id).orElse(null);
    }
}
