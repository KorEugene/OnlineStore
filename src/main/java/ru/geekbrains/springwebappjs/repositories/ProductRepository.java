package ru.geekbrains.springwebappjs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import ru.geekbrains.springwebappjs.entities.ProductEntity;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long>, JpaSpecificationExecutor<ProductEntity> {
    Optional<ProductEntity> findByTitle(String title);
}
