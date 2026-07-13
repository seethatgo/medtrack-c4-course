package com.medtrack.api.repository;

import com.medtrack.api.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

/** Persists and queries appointments in the database. */
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
