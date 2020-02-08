package com.main.app.controller;

import com.main.app.domain.dto.ClinicDTO;
import com.main.app.domain.dto.Entities;
import com.main.app.domain.model.AppointmentType;
import com.main.app.domain.model.Clinic;
import com.main.app.domain.model.DoctorTermin;
import com.main.app.repository.user.AppointmentTypeRepository;
import com.main.app.repository.user.ClinicRepository;
import com.main.app.repository.user.DoctorTerminRepository;
import com.main.app.service.DoctorTerminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/doctorTermin")
public class DoctorTerminController {

    private DoctorTerminService doctorTerminService;
    private AppointmentTypeRepository appointmentTypeRepository;
    private ClinicRepository clinicRepository;

    @Autowired
    public DoctorTerminController(DoctorTerminService doctorTerminService, AppointmentTypeRepository appointmentTypeRepository,
                                  ClinicRepository clinicRepository) {
        this.doctorTerminService = doctorTerminService;
        this.appointmentTypeRepository = appointmentTypeRepository;
        this.clinicRepository = clinicRepository;
    }

    @GetMapping(path = "/{clinicId}/{typeId}/{date}/{city}/{name}")
    public ResponseEntity<Entities> getFreeTermins(@PathVariable long clinicId, @PathVariable long typeId,
                                                   @PathVariable String date, @PathVariable String city, @PathVariable String name) {

        Optional<AppointmentType> type = appointmentTypeRepository.findById(typeId);
        Optional<Clinic> clinic = clinicRepository.findById(clinicId);

        Entities entities = new Entities();

        entities.setEntities(doctorTerminService.findAllByType(type.get(), date, city, clinic.get(), name));

        return new ResponseEntity<>(entities, HttpStatus.OK);
    }

    @GetMapping(path = "/clinics/{typeId}/{date}/{city}")
    public ResponseEntity<Entities> getFreeTerminsClnics(@PathVariable long typeId, @PathVariable String date, @PathVariable String city) {

        Optional<AppointmentType> type = appointmentTypeRepository.findById(typeId);

        Entities entities = new Entities();

        entities.setEntities(doctorTerminService.findAllClinicsByType(type.get(), date, city));

        return new ResponseEntity<>(entities, HttpStatus.OK);
    }

    @GetMapping(path = "/free/{clinicId}")
    public ResponseEntity<Entities> getFreeTerminsForClinic(@PathVariable long clinicId) {

        List<DoctorTermin> termins = doctorTerminService.getFreeTerminsForClinic(clinicId);

        Entities entities = new Entities();

        entities.setEntities(termins);

        return new ResponseEntity<>(entities, HttpStatus.OK);
    }
}
