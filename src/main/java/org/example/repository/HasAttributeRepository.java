package org.example.repository;

import org.example.key.HasAttributeKey;
import org.example.model.HasAttribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HasAttributeRepository extends JpaRepository<HasAttribute, HasAttributeKey> {
}
