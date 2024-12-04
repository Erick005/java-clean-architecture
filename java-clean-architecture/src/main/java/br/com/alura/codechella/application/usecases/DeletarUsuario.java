package br.com.alura.codechella.application.usecases;

import br.com.alura.codechella.application.gateways.RepositorioDeUsuario;

public class DeletarUsuario {

    private final RepositorioDeUsuario repositorioDeUsuario;

    public DeletarUsuario(RepositorioDeUsuario repositorioDeUsuario) {
        this.repositorioDeUsuario = repositorioDeUsuario;
    }

    public void deletarUsuario(String cpf) {
        repositorioDeUsuario.excluirUsuario(cpf);
    }
}
