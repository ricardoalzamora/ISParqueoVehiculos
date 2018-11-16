package com.is.sistemaparqueovehiculos.models.service;

import com.is.sistemaparqueovehiculos.models.dao.IInfraccionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class InfraccionService {

    @Autowired
    @Qualifier("infracciondao")
    private IInfraccionDao infraccionDao;
}
