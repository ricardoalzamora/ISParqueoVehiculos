package com.is.sistemaparqueovehiculos.models.service;

import com.is.sistemaparqueovehiculos.models.dao.IVehiculoDao;
import com.is.sistemaparqueovehiculos.models.entity.Vehiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class VehiculoService {

    @Autowired
    @Qualifier("vehiculodao")
    private IVehiculoDao vehiculoDao;

    public void guardar(Vehiculo vehiculo){
        vehiculoDao.save(vehiculo);
    }
}
