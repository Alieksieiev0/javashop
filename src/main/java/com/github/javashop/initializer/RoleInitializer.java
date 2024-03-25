package com.github.javashop.initializer;

import static com.github.javashop.config.Constants.ROLE_ADMIN;
import static com.github.javashop.config.Constants.ROLE_USER;

import com.github.javashop.model.Role;
import com.github.javashop.repository.RoleRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RoleInitializer implements CommandLineRunner {

    private final RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {
        findOrElseCreateByName(ROLE_ADMIN);
        findOrElseCreateByName(ROLE_USER);
    }

    private void findOrElseCreateByName(String name) {
        findOrElseCreate(Role.builder().name(name).build());
    }

    private void findOrElseCreate(Role role) {
        if (roleRepository.findByName(role.getName()).isPresent()) {
            return;
        }
        roleRepository.save(role);
    }
}
