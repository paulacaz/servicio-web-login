package com.servicio.loginapi.controller;

import com.servicio.loginapi.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    /**
     * Endpoint para registrar un nuevo usuario
     */
    @PostMapping("/registro")
    public  ResponseEntity<String> registrarUsuario(@RequestParam String username, @RequestParam String password) {
        String resultado = usuarioService.registrarUsuario(username, password);
        if(resultado.equals("Usuario registrado satisfactoriamente")) {
            return ResponseEntity.ok(resultado);
        }else {
            return ResponseEntity.badRequest().body(resultado);
        }
    }
}
