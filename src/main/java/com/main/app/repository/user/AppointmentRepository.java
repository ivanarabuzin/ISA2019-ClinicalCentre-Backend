package com.main.app.repository.user;

import com.main.app.domain.model.Appointment;
import com.main.app.domain.model.Clinic;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    List<Appointment> findAllByClinic(Clinic clinic, Pageable pageable);
}
