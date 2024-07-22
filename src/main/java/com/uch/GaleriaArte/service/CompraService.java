package com.uch.GaleriaArte.service;

import com.uch.GaleriaArte.entity.Compra;

import java.util.List;

public interface CompraService {
    List<Compra> findAllCompras();
    Compra saveCompra(Compra compra);
    Compra updateCompra(Long id, Compra compra);
    void deleteCompra(Long id);
}
