package ru.geekbrains.webmarket.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.webmarket.core.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role getRoleByName(String name);
}
