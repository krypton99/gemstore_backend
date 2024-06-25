package org.example.repository;

import org.example.model.Gemstone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GemstoneRepository extends JpaRepository<Gemstone, Integer> {
    @Query(value = "UPDATE is_delete = true FROM gemstone g WHERE g.id = ?1",nativeQuery = true)
    void softDeleteById(int id);
    @Query(value = "SELECT * FROM gemstone g WHERE g.is_deleted = true",nativeQuery = true)
    List<Gemstone> findAllDeletedGemstones();

    @Query(value = "UPDATE is_delete = false * FROM gemstone g WHERE g.id = ?1",nativeQuery = true)
    void restoreDeletedGemstone(int id);
}
