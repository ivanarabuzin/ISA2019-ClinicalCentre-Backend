package com.main.app.service;

import com.main.app.domain.model.AppointmentType;
import com.main.app.domain.model.Clinic;
import com.main.app.domain.model.DoctorTermin;
import com.main.app.domain.model.HallTermin;

import java.util.List;

public interface HallTerminService {

    List<HallTermin> findAllByClinicAndDate(String date, Clinic clinic);
    List<HallTermin> getFreeTerminsForClinic(long clinicId);

}
