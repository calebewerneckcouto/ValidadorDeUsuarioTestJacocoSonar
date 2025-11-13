package br.com.ada.service;

import java.util.Optional;
import br.com.ada.entity.User;
import br.com.ada.repository.UserRepository;

public class UserService {
    private final UserRepository userRepository;
    private final EmailService emailService;

    public UserService(UserRepository userRepository, EmailService emailService) {
        this.userRepository = userRepository;
        this.emailService = emailService;
    }

    public boolean registerUser(String email, String name){
        if (userRepository.emailExists(email)) {
            return false;
        }

        User user = new User(email, name);
        userRepository.saveUser(user);

        boolean emailEnviado = emailService.sendWelcomeEmail(user);
        if (!emailEnviado) {
            return false;
        }

        return true;
    }

    public Optional<User> getUserByEmail(String email){
        return userRepository.findByEmail(email);
    }
}
