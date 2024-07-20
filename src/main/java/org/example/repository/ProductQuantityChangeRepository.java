package org.example.repository;

import org.example.model.ProductQuantityChange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductQuantityChangeRepository extends JpaRepository<ProductQuantityChange, Long> {
}
