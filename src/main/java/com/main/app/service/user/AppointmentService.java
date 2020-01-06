package com.main.app.service.user;

import com.main.app.domain.model.Appointment;
import com.main.app.domain.model.Clinic;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AppointmentService {

    List<Appointment> findAllByClinic(Clinic clinic, Pageable pageable);
    Appointment save(Appointment appointment);
}
