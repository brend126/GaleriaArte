package com.uch.GaleriaArte.service;

import com.uch.GaleriaArte.entity.ObraDeArte;

import java.util.List;

public interface ObraDeArteService {
    List<ObraDeArte> findAllObraDeArte();
    ObraDeArte saveObraDeArte(ObraDeArte obraDeArte);
    ObraDeArte updateObraDeArte(Long id, ObraDeArte obraDeArte);
    void deleteObraDeArte(Long id);

}
