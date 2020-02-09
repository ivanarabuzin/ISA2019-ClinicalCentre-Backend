package com.main.app.service;

import com.main.app.domain.model.Appointment;
import com.main.app.domain.model.Clinic;
import com.main.app.domain.model.DoctorTermin;
import com.main.app.domain.model.HallTermin;
import com.main.app.domain.model.user.User;
import com.main.app.repository.user.AppointmentRepository;
import com.main.app.repository.user.DoctorTerminRepository;
import com.main.app.repository.user.HallTerminRepository;
import com.main.app.service.email.RegistrationEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private AppointmentRepository appointmentRepository;
    private DoctorTerminRepository doctorTerminRepository;
    private HallTerminRepository hallTerminRepository;
    private CurrentUserService currentUserService;
    private RegistrationEmailService registrationEmailService;

    @Autowired
    AppointmentServiceImpl(AppointmentRepository appointmentRepository, DoctorTerminRepository doctorTerminRepository,
                           CurrentUserService currentUserService, RegistrationEmailService registrationEmailService,
                           HallTerminRepository hallTerminRepository) {
        this.appointmentRepository = appointmentRepository;
        this.doctorTerminRepository = doctorTerminRepository;
        this.currentUserService = currentUserService;
        this.registrationEmailService = registrationEmailService;
        this.hallTerminRepository = hallTerminRepository;
    }

    @Override
    public List<Appointment> findAllByClinic(Clinic clinic, Pageable pageable) {
        return appointmentRepository.findAllByClinic(clinic, pageable);
    }

    @Override
    public List<Appointment> findAllByPatient(User patient, Pageable pageable) {
        return appointmentRepository.findAllByPatientAndAdminAcceptedAndPatientAccepted(patient, true,
                false, pageable);
    }

    @Override
    public List<Appointment> findAllByPatientHistory(User patient, Pageable pageable) {
        return appointmentRepository.findAllByPatientAndAdminAcceptedAndPatientAccepted(patient, true,
                true, pageable);
    }

    @Override
    public Appointment save(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public Appointment createFromTermin(long terminId) {

        DoctorTermin termin = doctorTerminRepository.findById(terminId).get();

        if(!termin.isFree()) {
            return null;
        }

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

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public Appointment approveAppointment(long appointmentId, long terminId, long hallId) {

        Appointment appointment = appointmentRepository.findById(appointmentId).get();
        DoctorTermin doctorTermin = doctorTerminRepository.findById(terminId).get();
        HallTermin hallTermin = hallTerminRepository.findById(hallId).get();

        if(appointment.getTermin().getId() == doctorTermin.getId()) {

            if(!hallTermin.isFree()) {
                return null;
            }

            appointment.setAdminAccepted(true);
            hallTermin.setFree(false);
            appointment.setHall(hallTermin.getHall());
            appointment.setHallTermin(hallTermin);

            appointmentRepository.save(appointment);
            hallTerminRepository.save(hallTermin);

            this.sendEmail(appointment);

            return appointment;
        }
        else {

            if(!doctorTermin.isFree()) {
                return null;
            }

            if(!hallTermin.isFree()) {
                return null;
            }

            DoctorTermin oldTermin = appointment.getTermin();
            oldTermin.setFree(true);
            doctorTermin.setFree(false);
            appointment.setTermin(doctorTermin);

            appointment.setAdminAccepted(true);
            appointment.setDate(doctorTermin.getDate());
            hallTermin.setFree(false);
            appointment.setHall(hallTermin.getHall());
            appointment.setHallTermin(hallTermin);

            appointmentRepository.save(appointment);
            hallTerminRepository.save(hallTermin);
            doctorTerminRepository.save(oldTermin);
            doctorTerminRepository.save(doctorTermin);

            this.sendEmail(appointment);

            return appointment;
        }
    }

    private void sendEmail(Appointment appointment) {

        String message = "Appointment approved: " + appointment.getDate() + " " +
                appointment.getHall().getName();

        registrationEmailService.sendBasicEmail("aivanarabuzin.isa2019@gmail.com",
                appointment.getPatient().getEmail(), message, "Appointment approve");
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public Appointment changePatientStatus(long appointmentId, boolean status) {

        Appointment appointment = appointmentRepository.findById(appointmentId).get();

        appointment.setPatientAccepted(status);

        if(!status) {
            appointment.setAdminAccepted(false);

            DoctorTermin termin = appointment.getTermin();
            HallTermin hallTermin = appointment.getHallTermin();
            termin.setFree(true);
            hallTermin.setFree(true);

            appointmentRepository.save(appointment);
            hallTerminRepository.save(hallTermin);
            doctorTerminRepository.save(termin);
        }

        appointmentRepository.save(appointment);

        return appointment;
    }
}
