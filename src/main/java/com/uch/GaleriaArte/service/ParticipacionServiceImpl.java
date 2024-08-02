package com.uch.GaleriaArte.service;

import com.uch.GaleriaArte.entity.Cliente;
import com.uch.GaleriaArte.entity.Participacion;
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

    public Participacion saveParticipacion(Participacion participacion) {
        return participacionRepository.save(participacion);
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

}
