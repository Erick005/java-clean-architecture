package br.com.alura.codechella.domain.entities.usuario;

import br.com.alura.codechella.domain.entities.Endereco;
import br.com.alura.codechella.domain.entities.FabricaUsuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class UsuarioTest {
    @Test
    public void naoDeveCadastrarUsuarioComCpfNoFormatoInvalido() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Usuario("123456789-00", "jucelino", LocalDate.parse("2000-12-02"), "jucelino@gmail.com"));

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Usuario("123.456789-00", "jucelino", LocalDate.parse("2000-12-02"), "jucelino@gmail.com"));

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Usuario("123.456.78900", "jucelino", LocalDate.parse("2000-12-02"), "jucelino@gmail.com"));

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Usuario("12345678900", "jucelino", LocalDate.parse("2000-12-02"), "jucelino@gmail.com"));

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Usuario("123456789", "jucelino", LocalDate.parse("2000-12-02"), "jucelino@gmail.com"));
    }

    @Test
    public void deveCriarUsuarioUsandoFabricaUsuario(){
        FabricaUsuario fabricaUsuario = new FabricaUsuario();
        Usuario usuario = fabricaUsuario.comNomeCpfNascimento("456.234.789-01", "Emily", LocalDate.parse("2000-12-02"));

        Assertions.assertEquals("Emily", usuario.getNome());

        usuario.setEndereco(new Endereco("12345-999", 34, "apt 24"));

        Assertions.assertEquals("12345-999", usuario.getEndereco().getCep());
    }
}
