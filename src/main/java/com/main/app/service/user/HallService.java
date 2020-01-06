package com.main.app.service.user;

import com.main.app.domain.model.Clinic;
import com.main.app.domain.model.Hall;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface HallService {
    List<Hall> findAllByClinic(Clinic clinic, Pageable pageable);
    Hall save(Hall hall);
}
