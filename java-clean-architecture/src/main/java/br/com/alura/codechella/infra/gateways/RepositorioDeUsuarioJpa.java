package br.com.alura.codechella.infra.gateways;


import br.com.alura.codechella.application.gateways.RepositorioDeUsuario;
import br.com.alura.codechella.domain.entities.usuario.Usuario;
import br.com.alura.codechella.infra.persistence.UsuarioEntity;
import br.com.alura.codechella.infra.persistence.UsuarioRepository;

import java.util.List;
import java.util.stream.Collectors;

public class RepositorioDeUsuarioJpa implements RepositorioDeUsuario {

    private final UsuarioRepository repository;
    private final UsuarioEntityMapper mapper;

    public RepositorioDeUsuarioJpa(UsuarioRepository repository, UsuarioEntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Usuario cadastrarUsuario(Usuario usuario) {
        UsuarioEntity usuarioEntity = mapper.toEntity(usuario);
        repository.save(usuarioEntity);
        return mapper.toDomain(usuarioEntity);
    }

    @Override
    public List<Usuario> listarTodos() {
        return repository.findAll().stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Usuario atualizarUsuario(String cpf, Usuario usuario) {
        UsuarioEntity usuarioEntity = repository.findByCpf(cpf);
        if (usuarioEntity != null) {
            var atualizado = mapper.toEntity(usuario);
            atualizado.setId(usuarioEntity.getId());
            repository.save(atualizado);
            return mapper.toDomain(atualizado);
        }
        return null;
    }

    @Override
    public void excluirUsuario(String cpf) {
        UsuarioEntity usuarioEntity = repository.findByCpf(cpf);
        repository.deleteById(usuarioEntity.getId());
    }
}
