/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.cCruzProgramacionNCapasSpring.JPA;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Alien 15
 */
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idusuario")
    private int IdUsuario;

    @Column(name = "nombre")
    private String Nombre;

    @Column(name = "apellidopaterno")
    private String ApellidoPaterno;

    @Column(name = "apellidomaterno")
    private String ApellidoMaterno;

    @Column(name = "edad")
    private Integer Edad; //Recuerda quitar edad ya que se calcula con la fecha!!!

    @Column(name = "sexo")
    private String Sexo;

    @Column(name = "fechanacimiento")
    private Date FechaNacimiento;

    @Column(name = "username")
    private String Username;

    @Column(name = "email")
    private String Email;

    @Column(name = "password")
    private String Password;

    @Column(name = "telefono")
    private String Telefono;

    @Column(name = "celular")
    private String Celular;

    @Column(name = "curp")
    private String Curp;

    @Lob
    @Column(name = "fotito")
    private String Fotito;

    @ManyToOne
    @JoinColumn(name = "idrol")
    public Rol Rol; //Propiedad Almacenada

    //La relación está mapeada por el atributo usuario en la entidad Direccion
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true) //Fetch indica cómo y cuándo se cargan los datos relacionados de otras tablas
    public List<Direccion> Direcciones = new ArrayList<>();
    
    public Usuario(com.digis01.cCruzProgramacionNCapasSpring.ML.Usuario usuario){
        this.Nombre = usuario.getNombre();
        this.ApellidoPaterno = usuario.getApellidoPaterno();
        this.ApellidoMaterno = usuario.getApellidoMaterno();
        this.Edad = usuario.getEdad();
        this.Sexo = usuario.getSexo();
        this.FechaNacimiento = usuario.getFechaNacimiento();
        this.Username = usuario.getUsername();
        this.Email = usuario.getEmail();
        this.Password = usuario.getPassword();
        this.Telefono = usuario.getTelefono();
        this.Celular = usuario.getCelular();
        this.Curp = usuario.getCurp();
        this.Fotito = usuario.getFotito();
        this.Rol = new Rol();
        this.Rol.setIdRol(usuario.Rol.getIdRol());
        
        //Direcciones: 
        for(com.digis01.cCruzProgramacionNCapasSpring.ML.Direccion direccione : usuario.Direcciones){
        
            //Inicializamos su espacio en memoria
            Direccion direccion = new Direccion();
            
            direccion.setCalle(direccione.getCalle());
            direccion.setNumeroInterior(direccione.getNumeroInterior());
            direccion.setNumeroExterior(direccione.getNumeroExterior());
            
            direccion.colonia = new Colonia();
            direccion.colonia.setIdColonia(direccione.Coloniia.getIdColonia());
            
            direccion.usuario = this;
//            direccion.colonia.Municipio = new Municipio();
//            direccion.colonia.Municipio.setIdMunicipio(direccione.Coloniia.Municipio.getIdMunicipio());
//            
//            direccion.colonia.Municipio.Estado = new Estado();
//            direccion.colonia.Municipio.Estado.setIdEstado(direccione.Coloniia.Municipio.Estado.getIdEstado());
//            
//            direccion.colonia.Municipio.Estado.Pais = new Pais();
//            direccion.colonia.Municipio.Estado.Pais.setIdPais(direccione.Coloniia.Municipio.Estado.Pais.getIdPais());
            
           Direcciones.add(direccion);
        }    
    }

    public Usuario() {
    }

    
    public int getIdUsuario() {
        return IdUsuario;
    }

    public void setIdAlumno(int IdAlumno) {
        this.IdUsuario = IdAlumno;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellidoPaterno() {
        return ApellidoPaterno;
    }

    public void setApellidoPaterno(String ApellidoPaterno) {
        this.ApellidoPaterno = ApellidoPaterno;
    }

    public String getApellidoMaterno() {
        return ApellidoMaterno;
    }

    public void setApellidoMaterno(String ApellidoMaterno) {
        this.ApellidoMaterno = ApellidoMaterno;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(Integer Edad) {
        this.Edad = Edad;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getCelular() {
        return Celular;
    }

    public void setCelular(String Celular) {
        this.Celular = Celular;
    }

    public String getCurp() {
        return Curp;
    }

    public void setCurp(String Curp) {
        this.Curp = Curp;
    }

    public String getFotito() {
        return Fotito;
    }

    public void setFotito(String Fotito) {
        this.Fotito = Fotito;
    }

    public Rol getRol() {
        return Rol;
    }

    public void setRol(Rol Rol) {
        this.Rol = Rol;
    }

    public List<Direccion> getDirecciones() {
        return Direcciones;
    }

    public void setDirecciones(List<Direccion> Direcciones) {
        this.Direcciones = Direcciones;
    }

    public Date getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(Date FechaNacimiento) {
        this.FechaNacimiento = FechaNacimiento;
    }

    

}
