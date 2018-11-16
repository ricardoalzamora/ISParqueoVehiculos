package com.is.sistemaparqueovehiculos.models.dao;

import com.is.sistemaparqueovehiculos.models.entity.EstadoVehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("estadovehiculodao")
public interface IEstadoVehiculoDao extends JpaRepository<EstadoVehiculo, Long> {

}
