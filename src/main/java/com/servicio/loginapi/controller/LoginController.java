package com.servicio.loginapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class LoginController {

    // Endpoint para el login
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String username, @RequestParam String password) {
        // Verifica si el usuario y la contraseña son correctos
        if("admin".equals(username) && "1234".equals(password)) {
            return ResponseEntity.ok("Autenticación satisfactoria");
        } else {
            return ResponseEntity.status(401).body("Error en la Autenticación");
        }
    }
}
