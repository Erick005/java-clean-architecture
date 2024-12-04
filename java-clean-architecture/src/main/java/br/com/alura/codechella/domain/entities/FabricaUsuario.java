package br.com.alura.codechella.domain.entities;

import br.com.alura.codechella.domain.entities.usuario.Usuario;

import java.time.LocalDate;

public class FabricaUsuario {

    private Usuario usuario;

    public Usuario comNomeCpfNascimento(String cpf, String nome, LocalDate nascimento) {
        this.usuario = new Usuario(cpf, nome, nascimento, "");
        return this.usuario;
    }

    public Usuario comEndereco(String cep, Integer numero, String complemento) {
        this.usuario.setEndereco(new Endereco(cep, numero, complemento));
        return this.usuario;
    }
}
