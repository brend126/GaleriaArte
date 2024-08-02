package com.uch.GaleriaArte.service;

import com.uch.GaleriaArte.entity.Participacion;

import java.util.List;

public interface ParticipacionService {
    List<Participacion> findAllParticipaciones();
    Participacion saveParticipacion(Participacion participacion);
    Participacion updateParticipacion(Long id, Participacion participacion);
    void deleteParticipacion(Long id);

}
