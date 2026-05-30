package com.tienda.api.infrastructure.config;

import com.tienda.api.domain.ports.input.UserServicePort;
import com.tienda.api.domain.ports.output.UserRepositoryPort;
import com.tienda.api.domain.service.UserService;
import com.tienda.api.infrastructure.adapters.output.persistence.adapter.UserPersistenceAdapter;
import com.tienda.api.infrastructure.adapters.output.persistence.repository.JpaUserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public UserRepositoryPort userRepositoryPort(JpaUserRepository repository) {
        return new UserPersistenceAdapter(repository);
    }

    @Bean
    public UserServicePort userServicePort(UserRepositoryPort repositoryPort) {
        return new UserService(repositoryPort);
    }
}