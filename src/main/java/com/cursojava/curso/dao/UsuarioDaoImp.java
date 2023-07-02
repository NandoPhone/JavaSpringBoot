package com.cursojava.curso.dao;

import com.cursojava.curso.model.usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Repository
@Transactional
public class UsuarioDaoImp implements UsuarioDao{

    @PersistenceContext
    private EntityManager entitymanager;
    @Override
    public List<usuario> getUsuarios() {
        String query="FROM usuario";

        return entitymanager.createQuery(query).getResultList();
    }
}
