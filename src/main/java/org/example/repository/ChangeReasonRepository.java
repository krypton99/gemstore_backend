package org.example.repository;

import org.example.model.ChangeReason;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChangeReasonRepository extends JpaRepository<ChangeReason, Long> {
}
