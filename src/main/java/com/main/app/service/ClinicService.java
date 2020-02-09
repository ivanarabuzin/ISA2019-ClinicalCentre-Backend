package com.main.app.service;

import com.main.app.domain.model.Clinic;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ClinicService {

    Page<Clinic> findAll(Pageable pageable);
    Clinic save(Clinic save);
    List<Clinic> getRateList(Pageable page);
    Clinic rate(long clinicId, int rate);
}
