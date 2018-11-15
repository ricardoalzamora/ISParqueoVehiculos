package com.is.sistemaparqueovehiculos.models.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "estadovehiculo")
public class EstadoVehiculo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String nombre;

    @OneToMany(mappedBy = "estadoVehiculo", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Vehiculo> vehiculos;

    public EstadoVehiculo() {
        this.vehiculos = new ArrayList<Vehiculo>();
    }

    public EstadoVehiculo(@NotEmpty String nombre) {
        this.nombre = nombre;
        this.vehiculos = new ArrayList<Vehiculo>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
}
