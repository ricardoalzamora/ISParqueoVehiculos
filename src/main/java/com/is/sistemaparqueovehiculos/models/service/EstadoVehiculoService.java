package com.is.sistemaparqueovehiculos.models.service;

import com.is.sistemaparqueovehiculos.models.dao.IEstadoVehiculoDao;
import com.is.sistemaparqueovehiculos.models.entity.EstadoVehiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoVehiculoService {

    @Autowired
    @Qualifier("estadovehiculodao")
    private IEstadoVehiculoDao estadoVehiculoDao;

    public EstadoVehiculo obtenerPorId(Long id){
        return estadoVehiculoDao.getOne(id);
    }
}
