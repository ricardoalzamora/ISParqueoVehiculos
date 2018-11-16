package com.is.sistemaparqueovehiculos.models.service;

import com.is.sistemaparqueovehiculos.models.dao.IUsuarioDao;
import com.is.sistemaparqueovehiculos.models.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    @Qualifier("usuariodao")
    private IUsuarioDao usuarioDao;

    public boolean crear(Usuario usuario){
        try{
            usuarioDao.save(usuario);
            return true;
        }catch (Exception e){
            return false;
        }
    }
    public boolean actualizar(Usuario usuario){
        try{
            usuarioDao.save(usuario);
            return true;
        }catch (Exception e){
            return false;
        }
    }
    public boolean borrar(Long id){
        try{
            usuarioDao.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public List<Usuario> obtener(){
        return usuarioDao.findAll();
    }

    public Usuario obtenerPorId(Long documento){
        return usuarioDao.getOne(documento);
    }
}
