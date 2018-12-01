package com.is.sistemaparqueovehiculos.models.dao;

import com.is.sistemaparqueovehiculos.models.entity.Registro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("registrodao")
public interface IRegistroDao extends JpaRepository<Registro, Long> {

    public abstract List<Registro> findAllById(Long id);

    public abstract List<Registro> findAllByClienteDocumento(Long id);

    @Query("select r from Registro r where r.vehiculo.placa like %?1%")
    public abstract List<Registro> findAllByVehiculoPlaca(String placa);
}
