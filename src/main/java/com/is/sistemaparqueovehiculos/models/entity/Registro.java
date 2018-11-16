package com.is.sistemaparqueovehiculos.models.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "registro")
public class Registro implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @NotNull
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "fecha_entrada")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    private Date fechaEntrada;

    @Column(name = "fecha_salida")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    private Date fechaSalida;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_vehiculo", referencedColumnName = "id")
    private Vehiculo vehiculo;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "zona_asignada", referencedColumnName = "id")
    private Zona zonaAsignada;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "documento_vigilante", referencedColumnName = "documento", insertable = false, updatable = false)
    private Usuario vigilante;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "documento_cliente", referencedColumnName = "documento",insertable = false, updatable = false)
    private Usuario cliente;

    @OneToMany(mappedBy = "registro", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Infraccion> infracciones;

    public Registro() {
        this.infracciones = new ArrayList<Infraccion>();
    }

    public Registro(@NotNull Date fechaEntrada, Date fechaSalida, @NotNull Vehiculo vehiculo, @NotNull Zona zonaAsignada, @NotNull Usuario vigilante, @NotNull Usuario cliente) {
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.vehiculo = vehiculo;
        this.zonaAsignada = zonaAsignada;
        this.vigilante = vigilante;
        this.cliente = cliente;
        this.infracciones = new ArrayList<Infraccion>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Zona getZonaAsignada() {
        return zonaAsignada;
    }

    public void setZonaAsignada(Zona zonaAsignada) {
        this.zonaAsignada = zonaAsignada;
    }

    public Usuario getVigilante() {
        return vigilante;
    }

    public void setVigilante(Usuario vigilante) {
        this.vigilante = vigilante;
    }

    public Usuario getCliente() {
        return cliente;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }

    public List<Infraccion> getInfracciones() {
        return infracciones;
    }

    public void setInfracciones(List<Infraccion> infracciones) {
        this.infracciones = infracciones;
    }

    public void agregarInfraccion(Infraccion infraccion){
        this.infracciones.add(infraccion);
    }
}
