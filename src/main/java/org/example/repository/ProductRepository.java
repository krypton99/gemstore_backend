package org.example.repository;

import org.example.model.Gemstone;
import org.example.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(value = "UPDATE is_delete = true FROM product p WHERE p.id = ?1",nativeQuery = true)
    void softDeleteById(long id);
    @Query(value = "SELECT * FROM product p WHERE p.is_deleted = true",nativeQuery = true)
    List<Product> findAllDeleted();

    @Query(value = "UPDATE is_delete = false * FROM product p WHERE p.id = ?1",nativeQuery = true)
    void restoreDeleted(long id);
}
