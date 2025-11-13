package br.com.ada.repository;

import br.com.ada.entity.User;

import java.util.Optional;

public interface UserRepository {
    void saveUser(User user);
    Optional<User> findByEmail(String email);
    boolean emailExists(String email);
}
