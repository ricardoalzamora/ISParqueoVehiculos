package com.is.sistemaparqueovehiculos.models.service;

import com.is.sistemaparqueovehiculos.models.dao.IEstadoVehiculoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class EstadoVehiculoService {

    @Autowired
    @Qualifier("estadovehiculodao")
    private IEstadoVehiculoDao estadoVehiculoDao;
}
