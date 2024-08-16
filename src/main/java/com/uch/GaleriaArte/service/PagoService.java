package com.uch.GaleriaArte.service;

import com.uch.GaleriaArte.entity.Pago;

import java.util.List;

public interface PagoService {
    List<Pago> findAllPagos();
    Pago savePago(Pago pago);
    Pago updatePago(Long id, Pago pago);
    void deletePago(Long id);

}
