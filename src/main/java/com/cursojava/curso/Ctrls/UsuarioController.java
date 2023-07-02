/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cursojava.curso.Ctrls;

import com.cursojava.curso.dao.UsuarioDao;
import com.cursojava.curso.model.usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioDao usuarioDao;

    //el request es la URL con la que se llama
    @RequestMapping(value = "usuario/{id}")
    public usuario getUsuario(@PathVariable Long id) {
        usuario usuario =new usuario();
        usuario.setId(id);
        usuario.setNombre("Fernando");
        usuario.setApellido("Alulima");
        usuario.setEmail("wfernandoalulima@gmail.com");
        usuario.setTelefono("0992146343");
        usuario.setPass("1234");

        return usuario;
    }
    @RequestMapping(value = "usuarios")
    public List<usuario> getUsuarios() {
        return usuarioDao.getUsuarios();
    }
    public usuario Modificar() {
        usuario usuario =new usuario();
        usuario.setNombre("Fernando");
        usuario.setApellido("Alulima");
        usuario.setEmail("wfernandoalulima@gmail.com");
        usuario.setTelefono("0992146343");
        usuario.setPass("1234");

        return usuario;
    }
    public usuario Eliminar() {
        usuario usuario =new usuario();
        usuario.setNombre("Fernando");
        usuario.setApellido("Alulima");
        usuario.setEmail("wfernandoalulima@gmail.com");
        usuario.setTelefono("0992146343");
        usuario.setPass("1234");

        return usuario;
    }
    public usuario Buscar() {
        usuario usuario =new usuario();
        usuario.setNombre("Fernando");
        usuario.setApellido("Alulima");
        usuario.setEmail("wfernandoalulima@gmail.com");
        usuario.setTelefono("0992146343");
        usuario.setPass("1234");

        return usuario;
    }
}
