package com.tienda.api.infrastructure.adapters.output.persistence.adapter;

import com.tienda.api.domain.model.User;
import com.tienda.api.domain.ports.output.UserRepositoryPort;
import com.tienda.api.infrastructure.adapters.output.persistence.entity.UserEntity;
import com.tienda.api.infrastructure.adapters.output.persistence.repository.JpaUserRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UserPersistenceAdapter implements UserRepositoryPort {

    private final JpaUserRepository repository;

    public UserPersistenceAdapter(JpaUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User save(User user) {

        UserEntity entity = new UserEntity();

        entity.setNombre(user.getNombre());
        entity.setEmail(user.getEmail());
        entity.setPassword(user.getPassword());
        entity.setRole(user.getRole());

        UserEntity saved = repository.save(entity);

        return new User(
                saved.getId(),
                saved.getNombre(),
                saved.getEmail(),
                saved.getPassword(),
                saved.getRole()
        );
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return repository.findByEmail(email)
                .map(entity -> new User(
                        entity.getId(),
                        entity.getNombre(),
                        entity.getEmail(),
                        entity.getPassword(),
                        entity.getRole()
                ));
    }

    @Override
    public List<User> findAll() {
        return repository.findAll()
                .stream()
                .map(entity -> new User(
                        entity.getId(),
                        entity.getNombre(),
                        entity.getEmail(),
                        entity.getPassword(),
                        entity.getRole()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
    repository.deleteById(id);
    }
}