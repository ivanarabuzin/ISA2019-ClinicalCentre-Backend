package com.main.app.controller;

import com.main.app.domain.dto.AppointmentDTO;
import com.main.app.domain.dto.AppointmentTypeDTO;
import com.main.app.domain.dto.Entities;
import com.main.app.domain.model.Appointment;
import com.main.app.domain.model.Clinic;
import com.main.app.repository.user.ClinicRepository;
import com.main.app.service.AppointmentService;
import com.main.app.service.AppointmentTypeService;
import com.main.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointment")
public class AppointmentController {

    private AppointmentService appointmentService;

    private UserService userService;
    private ClinicRepository clinicRepository;

    @Autowired
    public AppointmentController(AppointmentService appointmentService, UserService userService, ClinicRepository clinicRepository) {
        this.appointmentService = appointmentService;
        this.userService = userService;
        this.clinicRepository = clinicRepository;
    }

    @GetMapping(path="/")
    public ResponseEntity<Entities> findAllByClinic(Pageable pageable, @RequestParam(name = "clinicId") Long clinicId) {

        Clinic clinic = clinicRepository.findById(clinicId).get();

        Entities result = new Entities();
        result.setEntities(appointmentService.findAllByClinic(clinic, pageable));

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(path="/patient")
    public ResponseEntity<Entities> findAllByPatient(Pageable pageable) {

        Entities result = new Entities();
        result.setEntities(appointmentService.findAllByPatient(userService.getCurrentUser().get(), pageable));

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(path="/patient/history")
    public ResponseEntity<Entities> findAllByPatientHistory(Pageable pageable) {

        Entities result = new Entities();
        result.setEntities(appointmentService.findAllByPatientHistory(userService.getCurrentUser().get(), pageable));

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(path = "/unconfirmed")
    public ResponseEntity<Entities> findAllUnconfirmed(Pageable pageable) {
        Entities result = new Entities();

        Page<Appointment> appointmentList = appointmentService.findAllByAdminAccepted(false, pageable);

        result.setEntities(appointmentList.getContent());
        result.setTotal(appointmentList.getTotalElements());

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping(path="/")
    public ResponseEntity<AppointmentDTO> add(@RequestBody AppointmentDTO appointmentDTO) {

        Appointment saved = appointmentService.save(new Appointment(appointmentDTO));
        return new ResponseEntity<>(new AppointmentDTO(saved), HttpStatus.OK);
    }

    @PostMapping(path="/fromTermin/{terminId}")
    public ResponseEntity<AppointmentDTO> fromTermin(@PathVariable long terminId) {

        Appointment appointment = appointmentService.createFromTermin(terminId);

        return new ResponseEntity<>(new AppointmentDTO(appointment), HttpStatus.OK);
    }

    @PostMapping(path = "/approve/{appointmentId}/{terminId}/{hallId}")
    public ResponseEntity<AppointmentDTO> approveAppointment(@PathVariable long appointmentId, @PathVariable long terminId,
                                                             @PathVariable long hallId)
    {
        Appointment appointment = appointmentService.approveAppointment(appointmentId, terminId, hallId);

        return new ResponseEntity<>(new AppointmentDTO(appointment), HttpStatus.OK);
    }

    @PostMapping(path = "/accept/{appointmentId}")
    public ResponseEntity<AppointmentDTO> accept(@PathVariable long appointmentId) {

        Appointment appointment = appointmentService.changePatientStatus(appointmentId, true);

        return new ResponseEntity<>(new AppointmentDTO(appointment), HttpStatus.OK);
    }

    @PostMapping(path = "/reject/{appointmentId}")
    public ResponseEntity<AppointmentDTO> reject(@PathVariable long appointmentId) {

        Appointment appointment = appointmentService.changePatientStatus(appointmentId, false);

        return new ResponseEntity<>(new AppointmentDTO(appointment), HttpStatus.OK);
    }
}
