package com.main.app.repository.user;

import com.main.app.domain.model.Clinic;
import com.main.app.domain.model.Hall;
import com.main.app.domain.model.HallTermin;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HallTerminRepository extends JpaRepository<Hall, Long> {

    List<HallTermin> findAllByClinic(Clinic clinic);
}
