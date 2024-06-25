package org.example.repository;

import org.example.model.AttributeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AttributeTypeRepository extends JpaRepository<AttributeType, Integer> {
    @Query(value = "UPDATE is_delete = true FROM attribute_type a WHERE a.id = ?1",nativeQuery = true)
    void softDeleteById(int id);
}
