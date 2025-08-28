/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.cCruzProgramacionNCapasSpring.ML;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.util.ArrayList;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Alien 15
 */
public class Usuario {

    private int IdUsuario;

//    @Size(min = 3, max = 20, message = "Texto de entre 2 y 20 letras")
//    @NotEmpty(message = "Nombre Necesario ^o^")
    private String Nombre;

//    @Size(min = 3, max = 20, message = "Texto de entre 2 y 20 letras")
//    @NotEmpty(message = "Apellido paterno Necesario ^o^")
    private String ApellidoPaterno;

//    @Size(min = 3, max = 20, message = "Texto de entre 2 y 20 letras")
//    @NotEmpty(message = "Apellido materno Necesario ^o^")
    private String ApellidoMaterno;

//    @Min(10)
//    @Max(150)
    private int Edad; //Recuerda quitar edad ya que se calcula con la fecha!!!

    private String Sexo;

//    @Past
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date FechaNacimiento;

//    @NotBlank
    private String Username;

//    @Pattern(regexp="[a-zA-Z0-9_]+([.][a-zA-Z0-9_]+)*@[a-zA-Z0-9_]+([.][a-zA-Z0-9_]+)*[.][a-zA-Z]{2,5}", message = "Ingrese un email valido ┬┬﹏┬┬")
    private String Email;

    private String Password;

//    @Size(min = 10, max = 13, message = "entre 10 y 12 numeros")
    private String Telefono;

//     @Size(min = 10, max = 13, message = "entre 10 y 12 numeros")
    private String Celular;

//     @Size(min = 18, max = 18, message = "entre 10 y 12 numeros")
    private String Curp;

    private String Fotito; ///FOTO de usuario

    public Rol Rol; //Propiedad Almacenada

    public List<Direccion> Direcciones;

    public Usuario() {
    }

    public Usuario(String Nombre, String ApellidoPaterno, String ApellidoMaterno, int Edad, String Sexo, Date FechaNacimiento, String Username, String Email,
            String Password, String Telefono, String Celular, String Curp) {
//    this.IdUsuario = IdUsuario;
        this.Nombre = Nombre;
        this.ApellidoPaterno = ApellidoPaterno;
        this.ApellidoMaterno = ApellidoMaterno;
        this.Edad = Edad;
        this.Sexo = Sexo;
        this.FechaNacimiento = FechaNacimiento;
        this.Username = Username;
        this.Email = Email;
        this.Password = Password;
        this.Telefono = Telefono;
        this.Celular = Celular;
        this.Curp = Curp;
    }

    public Usuario(String Nombre, String ApellidoPaterno, String ApellidoMaterno, int Edad, String Sexo, Date FechaNacimiento, String Username, String Email, String Password, String Telefono, String Celular, String Curp, int IdRol) {
        this.Nombre = Nombre;
        this.ApellidoPaterno = ApellidoPaterno;
        this.ApellidoMaterno = ApellidoMaterno;
        this.Edad = Edad;
        this.Sexo = Sexo;
        this.FechaNacimiento = FechaNacimiento;
        this.Username = Username;
        this.Email = Email;
        this.Password = Password;
        this.Telefono = Telefono;
        this.Celular = Celular;
        this.Curp = Curp;
//       this.Rol = new ML.Rol(); Para poder usar la propiedad alamcenada debemos siempre inicializar la clase. Pero ya se inicializo desde otro lado. 
        this.Rol.setIdRol(IdRol);
    }

    public Usuario(String Nombre, String ApellidoPaterno, String ApellidoMaterno) { //Este contructor sirve para la busqueda abierta

        this.Nombre = Nombre;

        this.ApellidoPaterno = ApellidoPaterno;

        this.ApellidoMaterno = ApellidoMaterno;

    }

    public Usuario(com.digis01.cCruzProgramacionNCapasSpring.JPA.Usuario usuarioJPA) {
        this.IdUsuario = usuarioJPA.getIdUsuario();
        this.Nombre = usuarioJPA.getNombre();
        this.ApellidoPaterno = usuarioJPA.getApellidoPaterno();
        this.ApellidoMaterno = usuarioJPA.getApellidoMaterno();
        //this.Edad = usuarioJPA.getEdad();
        this.Sexo = usuarioJPA.getSexo();
        this.FechaNacimiento = usuarioJPA.getFechaNacimiento();
        this.Username = usuarioJPA.getUsername();
        this.Email = usuarioJPA.getEmail();
        this.Password = usuarioJPA.getPassword();
        this.Telefono = usuarioJPA.getTelefono();
        this.Celular = usuarioJPA.getCelular();
        this.Curp = usuarioJPA.getCurp();

        this.Rol = new Rol();
        this.Rol.setIdRol(usuarioJPA.Rol.getIdRol());
        this.Rol.setNombre(usuarioJPA.Rol.getNombre());
        if (usuarioJPA.Direcciones != null && usuarioJPA.Direcciones.size() > 0) {
            this.Direcciones = new ArrayList<>();
            for (com.digis01.cCruzProgramacionNCapasSpring.JPA.Direccion direc : usuarioJPA.Direcciones) {
                
                //Inicializacion de ML: 
                Direccion direccion = new Direccion();
                direccion.Coloniia = new Colonia();
                direccion.Coloniia.Municipio = new Municipio();
                direccion.Coloniia.Municipio.Estado = new Estado();
                direccion.Coloniia.Municipio.Estado.Pais = new Pais();
                
                
                
                com.digis01.cCruzProgramacionNCapasSpring.JPA.Colonia colonia = new com.digis01.cCruzProgramacionNCapasSpring.JPA.Colonia();
                direccion.Coloniia.setIdColonia(colonia.getIdColonia());
                direccion.Coloniia.setNombreColonia(colonia.getNombreColonia());
                direccion.Coloniia.setCodigoPostal(colonia.getCodigoPostal());
          
                direccion.setCalle(direc.getCalle());
                direccion.setNumeroExterior(direc.getNumeroExterior());
                direccion.setNumeroInterior(direc.getNumeroInterior());
                
                com.digis01.cCruzProgramacionNCapasSpring.JPA.Municipio municipio = new com.digis01.cCruzProgramacionNCapasSpring.JPA.Municipio();
                direccion.Coloniia.Municipio.setIdMunicipio(municipio.getIdMunicipio());
                direccion.Coloniia.Municipio.setNombreMunicipio(municipio.getNombreMunicipio());
                
                com.digis01.cCruzProgramacionNCapasSpring.JPA.Estado estado = new com.digis01.cCruzProgramacionNCapasSpring.JPA.Estado();
                direccion.Coloniia.Municipio.Estado.setIdEstado(estado.getIdEstado());
                direccion.Coloniia.Municipio.Estado.setNombreEstado(estado.getNombreEstado());
                
                com.digis01.cCruzProgramacionNCapasSpring.JPA.Pais pais = new com.digis01.cCruzProgramacionNCapasSpring.JPA.Pais();
                direccion.Coloniia.Municipio.Estado.Pais.setIdPais(pais.getIdPais());
                direccion.Coloniia.Municipio.Estado.Pais.setNombrePais(pais.getNombrePais());
              
                this.Direcciones.add(direccion);
            }
        
        }
   
    }

    public int getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(int IdUsuario) {
        this.IdUsuario = IdUsuario;
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

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }

    

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }

    public Date getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(Date FechaNacimiento) {
        this.FechaNacimiento = FechaNacimiento;
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

    public String getFotito() {
        return Fotito;
    }

    public void setFotito(String Fotito) {
        this.Fotito = Fotito;
    }

    public void setCurp(String Curp) {
        this.Curp = Curp;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
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

}
