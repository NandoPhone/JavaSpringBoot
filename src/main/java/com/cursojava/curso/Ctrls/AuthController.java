package com.cursojava.curso.Ctrls;

import com.cursojava.curso.dao.UsuarioDao;
import com.cursojava.curso.model.usuario;
import com.cursojava.curso.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AuthController {
    @Autowired
    private  UsuarioDao usuarioDao;

    @Autowired
    private JWTUtil jwtUtil;
    @RequestMapping(value = "api/login", method = RequestMethod.POST)
    public String login(@RequestBody usuario usuario) {
        usuario usuarioLogeado=usuarioDao.obtenerUsuarioPorCredenciales(usuario);
        if (usuarioLogeado !=null){
            //tokenJWT
            return jwtUtil.create(String.valueOf(usuarioLogeado.getId()),usuarioLogeado.getEmail());

        }
        return "Fail";
    }
}
