package com.uch.GaleriaArte.service;

import com.uch.GaleriaArte.entity.Cliente;
import com.uch.GaleriaArte.entity.ObraDeArte;
import com.uch.GaleriaArte.repository.ClienteRepository;
import com.uch.GaleriaArte.repository.ObraDeArteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ObraDeArteServiceImpl implements ObraDeArteService{

    @Autowired
    ObraDeArteRepository obraDeArteRepository;

    @Override
    public List<ObraDeArte> findAllObraDeArte() {
        return obraDeArteRepository.findAll();
    }

    @Override
    public ObraDeArte saveObraDeArte(ObraDeArte obraDeArte) {
        return obraDeArteRepository.save(obraDeArte);
    }

    @Override
    public ObraDeArte updateObraDeArte(Long id, ObraDeArte obraDeArte) {
        ObraDeArte obraDeArteDb = obraDeArteRepository.findById(id).get();
        if(Objects.nonNull(obraDeArte.getNombreArtista()) && !"".equalsIgnoreCase(obraDeArte.getNombreArtista())){
            obraDeArteDb.setNombreArtista(obraDeArte.getNombreArtista());
        }
        if(Objects.nonNull(obraDeArte.getTipoDeObra()) && !"".equalsIgnoreCase(obraDeArte.getTipoDeObra())){
            obraDeArteDb.setTipoDeObra(obraDeArte.getTipoDeObra());
        }
        if(Objects.nonNull(obraDeArte.getMovimientoArtistico()) && !"".equalsIgnoreCase(obraDeArte.getMovimientoArtistico())){
            obraDeArteDb.setMovimientoArtistico(obraDeArte.getMovimientoArtistico());
        }

        return obraDeArteRepository.save(obraDeArteDb);
    }

    @Override
    public void deleteObraDeArte(Long id) {
        obraDeArteRepository.deleteById(id);

    }
}