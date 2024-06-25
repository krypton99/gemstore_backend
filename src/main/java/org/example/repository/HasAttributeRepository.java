package org.example.repository;

import org.example.key.HasAttributeKey;
import org.example.model.HasAttribute;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HasAttributeRepository extends JpaRepository<HasAttribute, HasAttributeKey> {
}
