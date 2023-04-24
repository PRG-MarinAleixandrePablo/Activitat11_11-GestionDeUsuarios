package es.progcipfpbatoi.modelo.repositorios;

import es.progcipfpbatoi.modelo.entidades.Usuario;

import java.util.ArrayList;

public class InMemoryUsuariosRepository implements UsuariosRepository {

    private ArrayList<Usuario> listaUsuarios;

    public InMemoryUsuariosRepository() {
        this.listaUsuarios = new ArrayList<>();
    }


    @Override
    public boolean guardarUsuario(Usuario usuario) {
        return this.listaUsuarios.add(usuario);  //Retornara true o false dependiendo de si el usuario se ha añadido o no
    }

    @Override
    public ArrayList<Usuario> findAll() {
        return this.listaUsuarios;
    }

    @Override
    public ArrayList<Usuario> find(String dni) {
        ArrayList<Usuario> usuarios = new ArrayList<>();

        for (Usuario usuario: this.listaUsuarios) {
            if (usuario.getDni().equals(dni)) {
                usuarios.add(usuario);
            }
        }
        return usuarios;
    }
}
