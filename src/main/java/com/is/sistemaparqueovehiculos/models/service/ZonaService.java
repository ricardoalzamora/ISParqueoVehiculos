package com.is.sistemaparqueovehiculos.models.service;

import com.is.sistemaparqueovehiculos.models.dao.IZonaDao;
import com.is.sistemaparqueovehiculos.models.entity.Zona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZonaService {

    @Autowired
    @Qualifier("zonadao")
    private IZonaDao zonaDao;

    public List<Zona> obtener(){
        return zonaDao.findAll();
    }

    public Zona obtenerPorId(Long id){
        return zonaDao.getOne(id);
    }

    public void guardar(Zona zona){
        zonaDao.save(zona);
    }
}
