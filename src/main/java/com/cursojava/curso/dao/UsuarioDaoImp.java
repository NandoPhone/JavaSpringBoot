package com.cursojava.curso.dao;

import com.cursojava.curso.model.usuario;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Repository
@Transactional
public class UsuarioDaoImp implements UsuarioDao {

    @PersistenceContext
    private EntityManager entitymanager;

    @Override
    public List<usuario> getUsuarios() {
        String query = "FROM usuario";

        return entitymanager.createQuery(query).getResultList();
    }

    @Override
    public void eliminar(Long id) {
        usuario usuario = entitymanager.find(usuario.class, id);
        entitymanager.remove(usuario);
    }

    @Override
    public void registrar(usuario usuario) {
        entitymanager.merge(usuario);
    }

    @Override
    public usuario obtenerUsuarioPorCredenciales(usuario usuario) {
        String query = "From  usuario Where Email = :email ";
        List<usuario> lista = entitymanager.createQuery(query)
                .setParameter("email", usuario.getEmail())
                .getResultList();

        if (lista.isEmpty()){
            return null;
        }
        String PassHash=lista.get(0).getPassword();

        Argon2 argon2= Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        if (argon2.verify(PassHash, usuario.getPassword())){
            return lista.get(0);
        }
        return null;
    }


}
