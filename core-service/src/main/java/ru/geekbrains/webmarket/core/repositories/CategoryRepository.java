package ru.geekbrains.webmarket.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.geekbrains.webmarket.core.entities.CategoryEntity;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
    Optional<CategoryEntity> findByTitle(String title);

    @Query("select c from CategoryEntity c join fetch c.productEntities where c.id = :id")
    Optional<CategoryEntity> findByIdWithProducts(Long id);
}
