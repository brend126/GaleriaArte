package com.uch.GaleriaArte.service;

import com.uch.GaleriaArte.entity.Preferencia;

import java.util.List;

public interface PreferenciaService {
    List<Preferencia> findAllPreferencias();
    Preferencia savePreferencia(Preferencia preferencia);
    Preferencia updatePreferencia(Long id, Preferencia preferencia);
    void deletePreferencia(Long id);
}
