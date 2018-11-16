package com.is.sistemaparqueovehiculos.models.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "infraccion")
public class Infraccion implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", insertable = false, updatable = false)
    private Registro registro;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    private TipoInfraccion tipoInfraccion;

    public Infraccion() {
    }

    public Infraccion(@NotNull Registro registro, @NotNull TipoInfraccion tipoInfraccion) {
        this.registro = registro;
        this.tipoInfraccion = tipoInfraccion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Registro getRegistro() {
        return registro;
    }

    public void setRegistro(Registro registro) {
        this.registro = registro;
    }

    public TipoInfraccion getTipoInfraccion() {
        return tipoInfraccion;
    }

    public void setTipoInfraccion(TipoInfraccion tipoInfraccion) {
        this.tipoInfraccion = tipoInfraccion;
    }
}
