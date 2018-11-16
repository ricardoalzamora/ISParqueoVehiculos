package com.is.sistemaparqueovehiculos.models.service;

import com.is.sistemaparqueovehiculos.models.dao.IRegistroDao;
import com.is.sistemaparqueovehiculos.models.entity.Registro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistroService {

    @Autowired
    @Qualifier("registrodao")
    private IRegistroDao registroDao;


    public List<Registro> obtenerRegistrosPorId(Long documento){
        return registroDao.findAllById(documento);
    }

    public List<Registro> obtenerRegistrosPorDocumento(Long documento){
        return registroDao.findAllByClienteDocumento(documento);
    }
}
