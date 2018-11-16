package com.is.sistemaparqueovehiculos.models.dao;

import com.is.sistemaparqueovehiculos.models.entity.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("vehiculodao")
public interface IVehiculoDao extends JpaRepository<Vehiculo, Long> {

}
