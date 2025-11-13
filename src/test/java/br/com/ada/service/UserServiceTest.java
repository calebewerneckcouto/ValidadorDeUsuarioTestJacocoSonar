package br.com.ada.service;

import br.com.ada.entity.User;
import br.com.ada.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private EmailService emailService;

    @InjectMocks
    private UserService userService;

   
    @Test
    void deveCadastrarUsuarioComSucesso() {
        String email = "teste@ada.com";
        String nome = "Calebe";

        when(userRepository.emailExists(email)).thenReturn(false);
        when(emailService.sendWelcomeEmail(any(User.class))).thenReturn(true);

        boolean resultado = userService.registerUser(email, nome);

        assertTrue(resultado, "O cadastro deveria retornar true quando o e-mail é enviado com sucesso");
        verify(userRepository).saveUser(any(User.class));
        verify(emailService).sendWelcomeEmail(any(User.class));
    }

  
    @Test
    void deveRetornarFalsoSeEmailJaExistir() {
        String email = "existente@ada.com";
        String nome = "Calebe";

        when(userRepository.emailExists(email)).thenReturn(true);

        boolean resultado = userService.registerUser(email, nome);

        assertFalse(resultado, "Deveria retornar false se o e-mail já existe");
        verify(userRepository, never()).saveUser(any(User.class));
        verify(emailService, never()).sendWelcomeEmail(any(User.class));
    }

   
    @Test
    void deveRetornarFalsoSeEnvioDeEmailFalhar() {
        String email = "falha@ada.com";
        String nome = "Calebe";

        when(userRepository.emailExists(email)).thenReturn(false);
        when(emailService.sendWelcomeEmail(any(User.class))).thenReturn(false);

        boolean resultado = userService.registerUser(email, nome);

        assertFalse(resultado, "Deveria retornar false se o envio do e-mail falhar");
        verify(userRepository).saveUser(any(User.class));
        verify(emailService).sendWelcomeEmail(any(User.class));
    }

    @Test
    void deveRetornarUsuarioPorEmail() {
        String email = "buscar@ada.com";
        User usuarioEsperado = new User(email, "Calebe");

        when(userRepository.findByEmail(email)).thenReturn(Optional.of(usuarioEsperado));

        Optional<User> usuario = userService.getUserByEmail(email);

        assertTrue(usuario.isPresent(), "Deveria retornar um usuário existente");
        assertEquals("Calebe", usuario.get().getName());
        verify(userRepository).findByEmail(email);
    }
}
