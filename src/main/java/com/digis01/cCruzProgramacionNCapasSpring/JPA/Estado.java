/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.cCruzProgramacionNCapasSpring.JPA;

import com.digis01.cCruzProgramacionNCapasSpring.JPA.Pais;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Estado {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idestado")
    private int IdEstado;
    
    @Column(name = "nombre")
    private String NombreEstado;
    
    @ManyToOne
    @JoinColumn(name = "idpais")
    public Pais Pais;

    public int getIdEstado() {
        return IdEstado;
    }

    public void setIdEstado(int IdEstado) {
        this.IdEstado = IdEstado;
    }

    public String getNombreEstado() {
        return NombreEstado;
    }

    public void setNombreEstado(String NombreEstado) {
        this.NombreEstado = NombreEstado;
    }

    public Pais getPais() {
        return Pais;
    }

    public void setPais(Pais Pais) {
        this.Pais = Pais;
    }
    
    
}
