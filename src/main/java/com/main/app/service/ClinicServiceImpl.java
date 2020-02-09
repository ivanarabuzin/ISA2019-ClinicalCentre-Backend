package com.main.app.service;

import com.main.app.domain.model.Appointment;
import com.main.app.domain.model.Clinic;
import com.main.app.domain.model.user.User;
import com.main.app.repository.user.AppointmentRepository;
import com.main.app.repository.user.ClinicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClinicServiceImpl implements ClinicService {

    private ClinicRepository clinicRepository;
    private CurrentUserService currentUserService;
    private AppointmentRepository appointmentRepository;

    @Autowired
    public ClinicServiceImpl(ClinicRepository clinicRepository,
                             CurrentUserService currentUserService,
                             AppointmentRepository appointmentRepository) {
        this.currentUserService = currentUserService;
        this.appointmentRepository = appointmentRepository;
        this.clinicRepository = clinicRepository;
    }

    @Override
    public Page<Clinic> findAll(Pageable pageable) {
        return clinicRepository.findAll(pageable);
    }

    @Override
    public Clinic save(Clinic clinic) {
        return clinicRepository.save(clinic);
    }

    public List<Clinic> getRateList(Pageable page) {

        User user = currentUserService.getCurrentUser().get();

        List<Appointment> appointments = appointmentRepository.findAllByPatientAndAdminAcceptedAndPatientAccepted(user,
                true, true, page);

        List<Clinic> clinics = new ArrayList<>();

        for(Appointment a: appointments) {

            if(clinicExists(clinics, a.getClinic())) {
                continue;
            }

            clinics.add(a.getClinic());
        }

        return clinics;
    }

    private boolean clinicExists(List<Clinic> clinics, Clinic clinic) {

        for(Clinic c: clinics) {

            if(c.getId() == clinic.getId()) {
                return true;
            }
        }

        return false;
    }

    public Clinic rate(long clinicId, int rate) {

        Clinic clinic = clinicRepository.findById(clinicId).get();

        clinic.setRateCount(clinic.getRateCount() + 1);
        clinic.setRateSum(clinic.getRateSum() + rate);
        clinic.setAverageRate(clinic.getRateSum() / clinic.getRateCount());

        clinicRepository.save(clinic);

        return clinic;
    }
}
