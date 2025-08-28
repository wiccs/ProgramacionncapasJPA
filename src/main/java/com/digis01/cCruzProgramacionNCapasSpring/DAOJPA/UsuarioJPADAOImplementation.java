/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.cCruzProgramacionNCapasSpring.DAOJPA;

import com.digis01.cCruzProgramacionNCapasSpring.JPA.Usuario;
import com.digis01.cCruzProgramacionNCapasSpring.ML.Result;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Alien 15
 */
@Repository 
public class UsuarioJPADAOImplementation implements IUsuarioJPA {

    @Autowired

    private EntityManager entityManager;

    @Override

    public Result GetAll() {

        Result result = new Result();

        try {

            TypedQuery<Usuario> queryUsuario = entityManager.createQuery("FROM Usuario ORDER BY IdUsuario", Usuario.class);

            List<Usuario> usuarios = queryUsuario.getResultList();

            result.objects = new ArrayList<>();
            for (Usuario usuario : usuarios) {

                result.objects.add(new com.digis01.cCruzProgramacionNCapasSpring.ML.Usuario(usuario));

            }
            
            result.correct = true;

        } catch (Exception ex) {

            result.correct = false;
            result.errorMessage = ex.getLocalizedMessage();
            result.ex = ex;

        }

        return result;

    }

    @Override
    public Result GetDetail(int idUsuario) {
        Result result = new Result();
        try {
            TypedQuery<Usuario> queryUsuario = entityManager.createQuery("FROM Usuario WHERE ID = :id" ,Usuario.class);
            queryUsuario.setParameter("id", idUsuario);
            
            List<Usuario> usuarios = queryUsuario.getResultList(); //Obtiene los resultados en una lista. 
            result.objects = new ArrayList<>();
            
            for (Usuario usuario : usuarios) {

                result.objects.add(new com.digis01.cCruzProgramacionNCapasSpring.ML.Usuario(usuario));
                
            }
  
            
        } catch (Exception e) {
        }
        return result;
    }
    
    @Transactional
     @Override
    public Result Delete(int IdUsuario) {
        Result result = new Result();
        
        try{
        
            Usuario usuarioJPA = entityManager.find(Usuario.class, IdUsuario);
            entityManager.remove(usuarioJPA);
            
            result.correct = true; 
        }catch(Exception ex){
        
            result.correct = false;
            result.errorMessage = ex.getLocalizedMessage();
            result.ex = ex; 
        }
        return result;  
    }

    @Transactional
    @Override
    public Result Add(com.digis01.cCruzProgramacionNCapasSpring.ML.Usuario usuarioML) {
        Result result = new Result();
        try {
            Usuario usuarioJPA = new Usuario(usuarioML);
            entityManager.persist(usuarioJPA);
            
        } catch (Exception e) {
            result.correct = false;
            result.errorMessage = e.getLocalizedMessage();
            result.ex = e;
        }
        return result;
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
