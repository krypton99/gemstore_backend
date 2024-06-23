package org.example.repository;

import org.example.model.Attribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AttributeRepository extends JpaRepository<Attribute,Integer> {
    @Query(value = "UPDATE is_delete = true FROM attribute a WHERE a.id = ?1",nativeQuery = true)
    void softDeleteById(int id);
}
