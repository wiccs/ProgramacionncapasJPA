/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.digis01.cCruzProgramacionNCapasSpring.DAOJPA;

import com.digis01.cCruzProgramacionNCapasSpring.JPA.Usuario;
import com.digis01.cCruzProgramacionNCapasSpring.ML.Result;


/**
 *
 * @author Alien 15
 */
interface IUsuarioJPA {
            Result GetAll(); //Esto es un metodo abstracto, no lleva implementacion en una interfaz.
            Result GetDetail(int idUsuario);
            Result Add(Usuario usuario);
            Result UpdateUser(Usuario usuario);
            Result GetAllBusqueda(Usuario usuario);
}
