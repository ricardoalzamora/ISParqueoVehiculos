package com.is.sistemaparqueovehiculos.models.dao;

import com.is.sistemaparqueovehiculos.models.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("usuariodao")
public interface IUsuarioDao extends JpaRepository<Usuario, Long> {

    public abstract List<Usuario> findByNombre(String nombre);

    public abstract Usuario findByDocumento(Long documento);

}
