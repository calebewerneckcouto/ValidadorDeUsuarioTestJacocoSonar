package br.com.ada.service;

import br.com.ada.entity.User;

public interface EmailService {
    boolean sendWelcomeEmail(User user);
    boolean sendVerificationEmail(
            String email,
            String verificationCode);
}
