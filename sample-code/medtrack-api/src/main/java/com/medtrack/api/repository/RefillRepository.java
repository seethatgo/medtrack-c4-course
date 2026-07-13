package com.medtrack.api.repository;

import com.medtrack.api.model.RefillRequest;
import org.springframework.data.jpa.repository.JpaRepository;

/** Persists and queries prescription-refill requests in the database. */
public interface RefillRepository extends JpaRepository<RefillRequest, Long> {
}
