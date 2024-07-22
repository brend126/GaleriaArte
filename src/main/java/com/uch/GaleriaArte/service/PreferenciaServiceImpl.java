package com.uch.GaleriaArte.service;

import com.uch.GaleriaArte.entity.Compra;
import com.uch.GaleriaArte.entity.Preferencia;
import com.uch.GaleriaArte.repository.CompraRepository;
import com.uch.GaleriaArte.repository.PreferenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class PreferenciaServiceImpl implements PreferenciaService{

    @Autowired
    PreferenciaRepository preferenciaRepository;

    @Override
    public List<Preferencia> findAllPreferencias() {
        return preferenciaRepository.findAll();
    }

    @Override
    public Preferencia savePreferencia(Preferencia preferencia) {
        return preferenciaRepository.save(preferencia);
    }

    @Override
    public Preferencia updatePreferencia(Long id, Preferencia preferencia) {
        Preferencia preferenciaDb = preferenciaRepository.findById(id).get();
        if(Objects.nonNull(preferencia.getTiposDeArte()) && !"".equalsIgnoreCase(preferencia.getTiposDeArte())){
            preferenciaDb.setTiposDeArte(preferencia.getTiposDeArte());
        }
        if(Objects.nonNull(preferencia.getArtistasFavoritos()) && !"".equalsIgnoreCase(preferencia.getArtistasFavoritos())){
            preferenciaDb.setArtistasFavoritos(preferencia.getArtistasFavoritos());
        }
        if(Objects.nonNull(preferencia.getEstilosFavoritos()) && !"".equalsIgnoreCase(preferencia.getEstilosFavoritos())){
            preferenciaDb.setEstilosFavoritos(preferencia.getEstilosFavoritos());
        }
        return preferenciaRepository.save(preferenciaDb);
    }

    @Override
    public void deletePreferencia(Long id) {
        preferenciaRepository.deleteById(id);
    }
}
