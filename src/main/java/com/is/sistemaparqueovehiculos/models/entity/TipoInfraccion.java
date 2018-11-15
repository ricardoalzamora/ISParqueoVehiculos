package com.is.sistemaparqueovehiculos.models.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tipoinfraccion")
public class TipoInfraccion implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String nombre;

    @NotNull
    private float valor;

    @OneToMany(mappedBy = "tipoInfraccion", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Infraccion> infracciones;

    public TipoInfraccion() {
        infracciones = new ArrayList<Infraccion>();
    }

    public TipoInfraccion(@NotEmpty String nombre, @NotNull float valor) {
        this.nombre = nombre;
        this.valor = valor;
        infracciones = new ArrayList<Infraccion>();
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

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public List<Infraccion> getInfracciones() {
        return infracciones;
    }

    public void setInfracciones(List<Infraccion> infracciones) {
        this.infracciones = infracciones;
    }
}
