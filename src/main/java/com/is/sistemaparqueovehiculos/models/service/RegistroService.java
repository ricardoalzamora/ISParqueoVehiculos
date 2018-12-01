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

    public Registro obtenerPorId(Long id){
        return registroDao.getOne(id);
    }

    public List<Registro> obtenerRegistrosPorId(Long documento){
        return registroDao.findAllById(documento);
    }

    public List<Registro> obtenerRegistrosPorDocumento(Long documento){
        return registroDao.findAllByClienteDocumento(documento);
    }

    public void guardar(Registro registro){
        registroDao.save(registro);
    }

    public List<Registro> obtener(){
        return registroDao.findAll();
    }

    public List<Registro> obtenerPorPlaca(String placa){
        return  registroDao.findAllByVehiculoPlaca(placa);
    }
}
