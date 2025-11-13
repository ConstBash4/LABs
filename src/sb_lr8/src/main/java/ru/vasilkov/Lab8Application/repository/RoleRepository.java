package ru.vasilkov.Lab8Application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vasilkov.Lab8Application.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
