package com.cursojava.curso.dao;

import com.cursojava.curso.model.usuario;

import java.util.List;

public interface UsuarioDao {
    static boolean verificar(usuario usuario) {

        return false;
    }

    List<usuario> getUsuarios();

    void eliminar(Long id);

    void registrar(usuario usuario);


    usuario obtenerUsuarioPorCredenciales(usuario usuario);
}
