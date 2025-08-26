/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.cCruzProgramacionNCapasSpring.DAOJPA;

import com.digis01.cCruzProgramacionNCapasSpring.ML.Result;
import com.digis01.cCruzProgramacionNCapasSpring.ML.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Alien 15
 */
public class UsuarioJPADAOImplementation implements IUsuarioJPA{

    @Autowired

    private EntityManager entityManager;

    @Override

    public Result GetAll() {

        Result result = new Result();

        try {

            TypedQuery<Usuario> queryAlumno = entityManager.createQuery("FROM Alumno", Usuario.class);

            List<Usuario> usuarios = queryAlumno.getResultList();
            
            for(Usuario usuario : usuarios){
            result.objects.add(usuario); }
            
        } catch (Exception ex) {

            result.correct = false;

            result.errorMessage = ex.getLocalizedMessage();

            result.ex = ex;

        }

        return result;

    }

    @Override
    public Result GetDetail(int idAlumno) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Result Add(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Result UpdateUser(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Result GetAllBusqueda(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
