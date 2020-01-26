package com.main.app.repository.user;

import com.main.app.domain.model.AppointmentType;
import com.main.app.domain.model.Clinic;
import com.main.app.domain.model.DoctorTermin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorTerminRepository extends JpaRepository<DoctorTermin, Long> {

     List<DoctorTermin> findAllByType(AppointmentType type);
}
