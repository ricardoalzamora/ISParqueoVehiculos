package com.is.sistemaparqueovehiculos.models.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @NotNull
    private Long documento;

    @NotEmpty
    private String nombre;

    @NotEmpty
    private String apellido;

    @NotNull
    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;

    @NotEmpty
    @Email
    private String email;

    private String celular;

    @NotEmpty
    private String contrasenia;

    @NotEmpty
    private String direccion;

    @NotNull
    private int genero;

    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
    private List<Registro> registrosCliente;

    @OneToMany(mappedBy = "vigilante", fetch = FetchType.LAZY)
    private List<Registro> registrosVigilante;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipo_usuario", referencedColumnName = "id", insertable = false, updatable = false)
    private TipoUsuario tipoUsuario;

    @NotNull
    @Column(name = "tipo_documento")
    private int tipoDocumento;

    private String foto;

    public Usuario() {
        this.registrosCliente = new ArrayList<Registro>();
        this.registrosVigilante = new ArrayList<Registro>();
    }

    public Usuario(@NotNull Long documento, @NotEmpty String nombre, @NotEmpty String apellido, @NotNull Date fechaNacimiento, @NotEmpty @Email String email, String celular, @NotEmpty String contrasenia, @NotEmpty String direccion, @NotNull int genero, @NotNull TipoUsuario tipoUsuario, @NotNull int tipoDocumento, String foto) {
        this.documento = documento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.email = email;
        this.celular = celular;
        this.contrasenia = contrasenia;
        this.direccion = direccion;
        this.genero = genero;
        this.tipoUsuario = tipoUsuario;
        this.tipoDocumento = tipoDocumento;
        this.foto = foto;
        this.registrosCliente = new ArrayList<Registro>();
        this.registrosVigilante = new ArrayList<Registro>();
    }

    public Long getDocumento() {
        return documento;
    }

    public void setDocumento(Long documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getGenero() {
        return genero;
    }

    public void setGenero(int genero) {
        this.genero = genero;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public int getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(int tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public List<Registro> getRegistrosCliente() {
        return registrosCliente;
    }

    public void setRegistrosCliente(List<Registro> registros) {
        this.registrosCliente = registros;
    }

    public List<Registro> getRegistrosVigilante() {
        return registrosVigilante;
    }

    public void setRegistrosVigilante(List<Registro> registrosVigilante) {
        this.registrosVigilante = registrosVigilante;
    }

    public void addRegistroCliente(Registro registro){
        registrosCliente.add(registro);
    }

    public void addRegistroVigilante(Registro registro){
        registrosVigilante.add(registro);
    }
}
