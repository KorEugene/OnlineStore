package ru.geekbrains.springwebappjs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.geekbrains.springwebappjs.entities.ProductEntity;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long>, JpaSpecificationExecutor<ProductEntity> {
    Optional<ProductEntity> findByTitle(String title);

//    @Query("select p from ProductEntity p join fetch p.categoryEntity ce join fetch p.comments c join fetch c.user u where p.id = :id")
//    ProductEntity findByIdWithAllDetails(Long id);

//    @Query("select p.title, p.price, p.categoryEntity.title, p.comments from ProductEntity p where p.id = :id")
//    ProductEntity findByIdWithAllDetails(Long id);
}
