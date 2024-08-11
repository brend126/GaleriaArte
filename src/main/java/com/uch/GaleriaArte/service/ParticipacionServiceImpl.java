package com.uch.GaleriaArte.service;

import com.uch.GaleriaArte.entity.Participacion;
import com.uch.GaleriaArte.entity.ObraDeArte;
import com.uch.GaleriaArte.repository.ParticipacionRepository;
import com.uch.GaleriaArte.repository.ObraDeArteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParticipacionServiceImpl implements ParticipacionService {

    @Autowired
    private ParticipacionRepository participacionRepository;

    @Autowired
    private ObraDeArteRepository obraDeArteRepository;

    @Override
    public List<Participacion> findAllParticipaciones() {
        return participacionRepository.findAll();
    }

    @Override
    public Participacion saveParticipacion(Participacion participacion) {
        return participacionRepository.save(participacion);
    }

    @Override
    public Participacion updateParticipacion(Long id, Participacion participacion) {
        if (participacionRepository.existsById(id)) {
            participacion.setId(id);
            return participacionRepository.save(participacion);
        }
        throw new RuntimeException("Participacion not found");
    }

    @Override
    public void deleteParticipacion(Long id) {
        participacionRepository.deleteById(id);
    }

    @Override
    public Participacion addObraDeArteToParticipacion(Long participacionId, Long obraDeArteId) {
        Optional<Participacion> participacionOpt = participacionRepository.findById(participacionId);
        Optional<ObraDeArte> obraDeArteOpt = obraDeArteRepository.findById(obraDeArteId);

        if (participacionOpt.isPresent() && obraDeArteOpt.isPresent()) {
            Participacion participacion = participacionOpt.get();
            ObraDeArte obraDeArte = obraDeArteOpt.get();
            participacion.getObrasDeArte().add(obraDeArte);
            return participacionRepository.save(participacion);
        } else {
            throw new RuntimeException("Participacion or ObraDeArte not found");
        }
    }
}
