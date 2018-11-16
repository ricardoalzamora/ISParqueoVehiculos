package com.is.sistemaparqueovehiculos.models.service;

import com.is.sistemaparqueovehiculos.models.dao.IZonaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ZonaService {

    @Autowired
    @Qualifier("zonadao")
    private IZonaDao zonaDao;
}
