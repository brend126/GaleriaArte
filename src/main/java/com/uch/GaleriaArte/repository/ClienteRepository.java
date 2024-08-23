package com.uch.GaleriaArte.repository;

import com.uch.GaleriaArte.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
