package br.com.alura.codechella.infra.controller;

import br.com.alura.codechella.application.usecases.AlterarUsuario;
import br.com.alura.codechella.application.usecases.CriarUsuario;
import br.com.alura.codechella.application.usecases.DeletarUsuario;
import br.com.alura.codechella.application.usecases.ListarUsuario;
import br.com.alura.codechella.domain.entities.usuario.Usuario;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final CriarUsuario criarUsuario;
    private final ListarUsuario listarUsuario;
    private final AlterarUsuario alterarUsuario;
    private final DeletarUsuario deletarUsuario;

    public UsuarioController(CriarUsuario criarUsuario, ListarUsuario listarUsuario, AlterarUsuario alterarUsuario, DeletarUsuario deletarUsuario) {
        this.criarUsuario = criarUsuario;
        this.listarUsuario = listarUsuario;
        this.alterarUsuario = alterarUsuario;
        this.deletarUsuario = deletarUsuario;
    }

    @PostMapping
    public UsuarioDTO cadastrarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        Usuario salvo = criarUsuario.cadastrarUsuario(new Usuario(usuarioDTO.cpf(), usuarioDTO.nome(), usuarioDTO.nascimento(),
                usuarioDTO.email()));

        return new UsuarioDTO(salvo.getCpf(), salvo.getNome(), salvo.getNascimento(), salvo.getEmail());
    }

    @GetMapping("/listar")
    public List<UsuarioDTO> listarUsuario() {
        return listarUsuario.obterTodosUsuarios().stream()
                .map(u -> new UsuarioDTO(u.getCpf(), u.getNome(), u.getNascimento(), u.getEmail()))
                .collect(Collectors.toList());
    }

    @PutMapping("/{cpf}")
    public UsuarioDTO atulizarUsuario(@PathVariable String cpf, @RequestBody UsuarioDTO usuarioDTO) {
        Usuario salvo = alterarUsuario.atualizarUsuario(cpf, new Usuario(usuarioDTO.cpf(), usuarioDTO.nome(), usuarioDTO.nascimento(),
                usuarioDTO.email()));

        return new UsuarioDTO(salvo.getCpf(), salvo.getNome(), salvo.getNascimento(), salvo.getEmail());
    }

    @DeleteMapping("/{cpf}")
    public void deletarUsuario(@PathVariable String cpf) {
        deletarUsuario.deletarUsuario(cpf);
    }
}
