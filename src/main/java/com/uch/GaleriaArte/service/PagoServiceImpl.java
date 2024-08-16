package com.uch.GaleriaArte.service;

import com.uch.GaleriaArte.entity.Cliente;
import com.uch.GaleriaArte.entity.Pago;
import com.uch.GaleriaArte.repository.ClienteRepository;
import com.uch.GaleriaArte.repository.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class PagoServiceImpl implements PagoService{

    @Autowired
    PagoRepository pagoRepository;

    @Override
    public List<Pago> findAllPagos() {
        return pagoRepository.findAll();
    }

    @Override
    public Pago savePago(Pago pago) {
        return pagoRepository.save(pago);
    }

    @Override
    public Pago updatePago(Long id, Pago pago) {
        Pago pagoDb = pagoRepository.findById(id).get();
        if(Objects.nonNull(pago.getMetodoDePago()) && !"".equalsIgnoreCase(pago.getMetodoDePago())){
            pagoDb.setMetodoDePago(pago.getMetodoDePago());
        }
        if(Objects.nonNull(pago.getHistorialDePagos()) && !"".equalsIgnoreCase(pago.getHistorialDePagos())){
            pagoDb.setHistorialDePagos(pago.getHistorialDePagos());
        }

        return pagoRepository.save(pagoDb);
    }

    @Override
    public void deletePago(Long id) {
        pagoRepository.deleteById(id);

    }
}
