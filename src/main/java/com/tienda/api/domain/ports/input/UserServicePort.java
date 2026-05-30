package com.tienda.api.domain.ports.input;

import com.tienda.api.domain.model.User;

import java.util.List;

public interface UserServicePort {

    User createUser(User user);

    List<User> getUsers();

    void deleteUser(Long id);
}