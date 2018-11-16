package com.is.sistemaparqueovehiculos.models.dao;

import com.is.sistemaparqueovehiculos.models.entity.Zona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("zonadao")
public interface IZonaDao extends JpaRepository<Zona, Long> {
}
