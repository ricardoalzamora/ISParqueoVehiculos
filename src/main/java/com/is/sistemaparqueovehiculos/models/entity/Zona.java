package com.is.sistemaparqueovehiculos.models.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "zona")
public class Zona implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String nombre;

    @NotNull
    private int capacidad;

    @NotNull
    @Column(name = "capacidad_utilizada")
    private int capacidadUtilizada;

    @NotNull
    private int habilitada;

    @OneToMany(mappedBy = "zonaAsignada", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Registro> registros;

    public Zona() {
        this.registros = new ArrayList<Registro>();
    }

    public Zona(@NotEmpty String nombre, @NotNull int capacidad, @NotNull int capacidadUtilizada, @NotNull int habilitada) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.capacidadUtilizada = capacidadUtilizada;
        this.habilitada = habilitada;
        this.registros = new ArrayList<Registro>();
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

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getCapacidadUtilizada() {
        return capacidadUtilizada;
    }

    public void setCapacidadUtilizada(int capacidadUtilizada) {
        this.capacidadUtilizada = capacidadUtilizada;
    }

    public int getHabilitada() {
        return habilitada;
    }

    public void setHabilitada(int habilitada) {
        this.habilitada = habilitada;
    }

    public List<Registro> getRegistros() {
        return registros;
    }

    public void setRegistros(List<Registro> registros) {
        this.registros = registros;
    }

    private void addRegistro(Registro registro){
        this.registros.add(registro);
    }
}
