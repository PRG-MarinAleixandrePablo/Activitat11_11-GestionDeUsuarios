package es.progcipfpbatoi.modelo.repositorios;

import es.progcipfpbatoi.modelo.entidades.Usuario;

import java.util.ArrayList;

public interface UsuariosRepository {
    boolean guardarUsuario(Usuario usuario);  //Guardar el usuario que nos pasan por parametro

    ArrayList<Usuario> findAll();

    ArrayList<Usuario> find(String dni);
}
