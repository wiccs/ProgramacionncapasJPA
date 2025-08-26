/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.cCruzProgramacionNCapasSpring.JPA;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import java.util.Date;

/**
 *
 * @author Alien 15
 */

  @Entity
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idalumno")
    private int IdAlumno;
    
    @Column(name = "nombre")
    private String Nombre;

    @Column(name = "apellidopaterno")
    private String ApellidoPaterno;

    @Column(name = "apellidomaterno")
    private String ApellidoMaterno;
    
    @Column(name = "edad")
    private int Edad; //Recuerda quitar edad ya que se calcula con la fecha!!!

    @Column(name = "sexo")
    private String Sexo;
    
    @Column(name = "fechaNacimiento")
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
    @Column( name = "fotito")
    private String Fotito; 
  
   @ManyToOne
   @JoinColumn( name = "idrol")
   public Rol Rol; //Propiedad Almacenada
  
   
 
  
    
}
