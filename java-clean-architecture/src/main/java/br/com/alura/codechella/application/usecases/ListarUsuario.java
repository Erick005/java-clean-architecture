package br.com.alura.codechella.application.usecases;

import br.com.alura.codechella.application.gateways.RepositorioDeUsuario;
import br.com.alura.codechella.domain.entities.usuario.Usuario;

import java.util.List;

public class ListarUsuario {

    private final RepositorioDeUsuario repositorio;

    public ListarUsuario(RepositorioDeUsuario repositorio) {
        this.repositorio = repositorio;
    }

    public List<Usuario> obterTodosUsuarios() {
        return repositorio.listarTodos();
    }
}
