package com.main.app.service;

import com.main.app.domain.model.AppointmentType;
import com.main.app.domain.model.DoctorTermin;

import java.util.List;

public interface DoctorTerminService {

    List<DoctorTermin> findAllByType(AppointmentType type, String date);
}
