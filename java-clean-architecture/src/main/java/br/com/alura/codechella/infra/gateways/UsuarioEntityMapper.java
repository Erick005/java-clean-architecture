package br.com.alura.codechella.infra.gateways;

import br.com.alura.codechella.domain.entities.usuario.Usuario;
import br.com.alura.codechella.infra.persistence.UsuarioEntity;

public class UsuarioEntityMapper {

    public UsuarioEntity toEntity(Usuario usuario) {
        return new UsuarioEntity(usuario.getCpf(), usuario.getNome(), usuario.getNascimento(), usuario.getEmail());
    }

    public Usuario toDomain(UsuarioEntity usuario) {
        return new Usuario(usuario.getCpf(), usuario.getNome(), usuario.getNascimento(), usuario.getEmail());
    }
}
