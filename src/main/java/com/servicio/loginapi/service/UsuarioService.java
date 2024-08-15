package com.servicio.loginapi.service;

import com.servicio.loginapi.model.Usuario;
import  org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    /**
     * Lista para almacenar los usuarios registrados (almacenamiento en memoria)
     */
    private List<Usuario> usuarios = new ArrayList<>();

    /**
     * Método para registrar un nuevo usuario
     * @param username
     * @param password
     * @return
     */
    public String registrarUsuario(String username, String password) {
        /**
         * Verificar si el nombre de usuario ya existe
         */
        Optional<Usuario> usuarioExistente = usuarios.stream()
                .filter(usuario -> usuario.getUsername().equals(username))
                .findFirst();

        if (usuarioExistente.isPresent()) {
            return "Error: El nombre de usuario ya existe.";
        }

        /**
         * Registrar el nuevo usuario
         */
        usuarios.add(new Usuario(username, password));
        return "Usuario registrado satisfactoriamente";
    }

    /**
     * Método para obtener todos los usuarios (opcional, solo para pruebas)
     * @return
     */
    public List<Usuario> obtenerUsuarios() {
        return usuarios;
    }
}
