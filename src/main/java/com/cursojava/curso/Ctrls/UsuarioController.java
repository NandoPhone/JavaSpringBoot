/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cursojava.curso.Ctrls;

import com.cursojava.curso.dao.UsuarioDao;
import com.cursojava.curso.model.usuario;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioDao usuarioDao;

    //el request es la URL con la que se llama
    @RequestMapping(value = "api/usuarios/{id}")
    public usuario getUsuario(@PathVariable Long id) {
        usuario usuario =new usuario();
        usuario.setId(id);
        usuario.setNombre("Fernando");
        usuario.setApellido("Alulima");
        usuario.setEmail("wfernandoalulima@gmail.com");
        usuario.setTelefono("0992146343");
        usuario.setPassword("1234");

        return usuario;
    }
    @RequestMapping(value = "api/usuarios")
    public List<usuario> getUsuarios() {
        return usuarioDao.getUsuarios();
    }

    @RequestMapping(value = "api/usuarios", method = RequestMethod.POST)
    //@RequestBody es para que convierta el json a un usuario automaticamente
    public void registrarUsuario(@RequestBody usuario usuario) {
        Argon2 argon2= Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash=argon2.hash(1,1024,1,usuario.getPassword());
        usuario.setPassword(hash);

        usuarioDao.registrar(usuario);
    }
    public usuario Modificar() {
        usuario usuario =new usuario();
        usuario.setNombre("Fernando");
        usuario.setApellido("Alulima");
        usuario.setEmail("wfernandoalulima@gmail.com");
        usuario.setTelefono("0992146343");
        usuario.setPassword("1234");

        return usuario;
    }
    @RequestMapping(value = "api/usuarios/{id}", method = RequestMethod.DELETE)
    public void eliminar(@PathVariable Long id) {
       usuarioDao.eliminar(id);
    }
    public usuario Buscar() {
        usuario usuario =new usuario();
        usuario.setNombre("Fernando");
        usuario.setApellido("Alulima");
        usuario.setEmail("wfernandoalulima@gmail.com");
        usuario.setTelefono("0992146343");
        usuario.setPassword("1234");

        return usuario;
    }
}
