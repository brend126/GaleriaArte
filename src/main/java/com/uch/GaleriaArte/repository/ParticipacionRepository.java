package com.uch.GaleriaArte.repository;

import com.uch.GaleriaArte.entity.Participacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface ParticipacionRepository extends CrudRepository<Participacion, Long> {
    Collection<Participacion> findAll();
}
