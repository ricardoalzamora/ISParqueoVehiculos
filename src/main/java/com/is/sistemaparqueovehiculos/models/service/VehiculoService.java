package com.is.sistemaparqueovehiculos.models.service;

import com.is.sistemaparqueovehiculos.models.dao.IVehiculoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class VehiculoService {

    @Autowired
    @Qualifier("vehiculodao")
    private IVehiculoDao vehiculoDao;
}
