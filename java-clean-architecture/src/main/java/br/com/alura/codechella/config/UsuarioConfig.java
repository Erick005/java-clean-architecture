package br.com.alura.codechella.config;

import br.com.alura.codechella.application.gateways.RepositorioDeUsuario;
import br.com.alura.codechella.application.usecases.AlterarUsuario;
import br.com.alura.codechella.application.usecases.CriarUsuario;
import br.com.alura.codechella.application.usecases.DeletarUsuario;
import br.com.alura.codechella.application.usecases.ListarUsuario;
import br.com.alura.codechella.infra.gateways.RepositorioDeUsuarioJpa;
import br.com.alura.codechella.infra.gateways.UsuarioEntityMapper;
import br.com.alura.codechella.infra.persistence.UsuarioRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UsuarioConfig {

    @Bean
    CriarUsuario criarUsuario(RepositorioDeUsuario repositorioDeUsuario) {
        return new CriarUsuario(repositorioDeUsuario);
    }

    @Bean
    ListarUsuario listarUsuario(RepositorioDeUsuario repositorioDeUsuario) {
        return new ListarUsuario(repositorioDeUsuario);
    }

    @Bean
    AlterarUsuario alterarUsuario(RepositorioDeUsuario repositorioDeUsuario) {
        return new AlterarUsuario(repositorioDeUsuario);
    }

    @Bean
    DeletarUsuario deletarUsuario(RepositorioDeUsuario repositorioDeUsuario) {
        return new DeletarUsuario(repositorioDeUsuario);
    }

    @Bean
    RepositorioDeUsuarioJpa criarRepositorioJpa(UsuarioRepository repository, UsuarioEntityMapper mapper){
        return new RepositorioDeUsuarioJpa(repository, mapper);
    }

    @Bean
    UsuarioEntityMapper retornaUsuarioEntityMapper() {
        return new UsuarioEntityMapper();
    }


}
