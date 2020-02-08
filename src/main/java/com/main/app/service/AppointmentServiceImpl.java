package com.main.app.service;

import com.main.app.domain.model.Appointment;
import com.main.app.domain.model.Clinic;
import com.main.app.domain.model.DoctorTermin;
import com.main.app.domain.model.user.User;
import com.main.app.repository.user.AppointmentRepository;
import com.main.app.repository.user.DoctorTerminRepository;
import com.main.app.service.email.RegistrationEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private AppointmentRepository appointmentRepository;
    private DoctorTerminRepository doctorTerminRepository;
    private CurrentUserService currentUserService;
    private RegistrationEmailService registrationEmailService;

    @Autowired
    AppointmentServiceImpl(AppointmentRepository appointmentRepository, DoctorTerminRepository doctorTerminRepository,
                           CurrentUserService currentUserService, RegistrationEmailService registrationEmailService) {
        this.appointmentRepository = appointmentRepository;
        this.doctorTerminRepository = doctorTerminRepository;
        this.currentUserService = currentUserService;
        this.registrationEmailService = registrationEmailService;
    }

    @Override
    public List<Appointment> findAllByClinic(Clinic clinic, Pageable pageable) {
        return appointmentRepository.findAllByClinic(clinic, pageable);
    }

    @Override
    public List<Appointment> findAllByPatient(User patient, Pageable pageable) {
        return appointmentRepository.findAllByPatient(patient, pageable);
    }

    @Override
    public Appointment save(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public Appointment createFromTermin(long terminId) {

        DoctorTermin termin = doctorTerminRepository.findById(terminId).get();

        Appointment appointment = new Appointment();
        appointment.setDate(termin.getDate());
        appointment.setDoctor(termin.getDoctor());
        appointment.setPrice(termin.getPrice());
        appointment.setClinic(termin.getDoctor().getClinic());
        appointment.setType(termin.getType());
        appointment.setPatient(currentUserService.getCurrentUser().get());
        appointment.setDescription("");
        appointment.setAdminAccepted(false);
        appointment.setPatientAccepted(false);
        appointment.setTermin(termin);

        termin.setFree(false);

        appointmentRepository.save(appointment);
        doctorTerminRepository.save(termin);

        registrationEmailService.sendAdminAppointmentNotification("vanarabuzin.isa2019@gmail.com",
                "aivanarabuzin.isa2019@gmail.com", "You have new appointment");

        return appointment;
    }

    public Page<Appointment> findAllByAdminAccepted(boolean adminAccepted, Pageable pageable) {
        return appointmentRepository.findAllByAdminAccepted(adminAccepted, pageable);
    }
}
