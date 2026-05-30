package com.tienda.api.infrastructure.adapters.input.controller;

import com.tienda.api.domain.model.User;
import com.tienda.api.domain.ports.input.UserServicePort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserServicePort servicePort;

    public UserController(UserServicePort servicePort) {
        this.servicePort = servicePort;
    }

    @PostMapping
    public User create(@RequestBody User user) {
        return servicePort.createUser(user);
    }

    @GetMapping
    public List<User> list() {
        return servicePort.getUsers();
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        servicePort.deleteUser(id);
    }
}