package com.tienda.api.domain.service;

import com.tienda.api.domain.model.User;
import com.tienda.api.domain.ports.input.UserServicePort;
import com.tienda.api.domain.ports.output.UserRepositoryPort;

import java.util.List;

public class UserService implements UserServicePort {

    private final UserRepositoryPort repositoryPort;

    public UserService(UserRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    @Override
    public User createUser(User user) {

        repositoryPort.findByEmail(user.getEmail())
                .ifPresent(u -> {
                    throw new RuntimeException("El correo ya existe");
                });

        return repositoryPort.save(user);
    }

    @Override
    public List<User> getUsers() {
        return repositoryPort.findAll();
    }

    @Override
    public void deleteUser(Long id) {
    repositoryPort.deleteById(id);
    }
}