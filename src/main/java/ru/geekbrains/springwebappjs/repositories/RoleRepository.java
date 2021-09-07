package ru.geekbrains.springwebappjs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.springwebappjs.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role getRoleByName(String name);
}
