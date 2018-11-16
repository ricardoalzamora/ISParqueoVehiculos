package com.is.sistemaparqueovehiculos.models.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tipousuario")
public class TipoUsuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @NotNull
    private Long id;

    @NotEmpty
    private String nombre;

    @OneToMany(mappedBy = "tipoUsuario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Usuario> usuarios;

    public TipoUsuario() {
        this.usuarios = new ArrayList<Usuario>();
    }

    public TipoUsuario(@NotNull Long id, @NotEmpty String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.usuarios = new ArrayList<Usuario>();
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
}
