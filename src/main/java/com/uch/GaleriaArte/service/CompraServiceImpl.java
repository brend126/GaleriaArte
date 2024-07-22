package com.uch.GaleriaArte.service;

import com.uch.GaleriaArte.entity.Compra;
import com.uch.GaleriaArte.repository.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CompraServiceImpl implements CompraService {

    @Autowired
    CompraRepository compraRepository;

    @Override
    public List<Compra> findAllCompras() {
        return compraRepository.findAll();
    }

    @Override
    public Compra saveCompra(Compra compra) {
        return compraRepository.save(compra);
    }

    @Override
    public Compra updateCompra(Long id, Compra compra) {

        Compra compraDb = compraRepository.findById(id).get();
        if(Objects.nonNull(compra.getObraDeArte()) && !"".equalsIgnoreCase(compra.getObraDeArte())){
            compraDb.setObraDeArte(compra.getObraDeArte());
        }
        if(Objects.nonNull(compra.getFechaCompra()) && !"".equalsIgnoreCase(String.valueOf(compra.getFechaCompra()))){
            compraDb.setFechaCompra(compra.getFechaCompra());
        }
        if(Objects.nonNull(compra.getMonto()) && !"".equalsIgnoreCase(String.valueOf(compra.getMonto()))){
            compraDb.setMonto(compra.getMonto());
        }
        return compraRepository.save(compraDb);
    }

    @Override
    public void deleteCompra(Long id) {
        compraRepository.deleteById(id);
    }
}
