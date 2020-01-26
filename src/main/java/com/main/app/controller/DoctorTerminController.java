package com.main.app.controller;

import com.main.app.domain.dto.ClinicDTO;
import com.main.app.domain.dto.Entities;
import com.main.app.domain.model.AppointmentType;
import com.main.app.repository.user.AppointmentTypeRepository;
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
import java.util.Optional;

@RestController
@RequestMapping("/api/doctorTermin")
public class DoctorTerminController {

    private DoctorTerminService doctorTerminService;
    private AppointmentTypeRepository appointmentTypeRepository;

    @Autowired
    public DoctorTerminController(DoctorTerminService doctorTerminService, AppointmentTypeRepository appointmentTypeRepository) {
        this.doctorTerminService = doctorTerminService;
        this.appointmentTypeRepository = appointmentTypeRepository;
    }

    @GetMapping(path = "/{typeId}/{date}")
    public ResponseEntity<Entities> getFreeTermins(@PathVariable long typeId, @PathVariable String date) {

        Optional<AppointmentType> type = appointmentTypeRepository.findById(typeId);

        Entities entities = new Entities();

        entities.setEntities(doctorTerminService.findAllByType(type.get(), date));

        return new ResponseEntity<>(entities, HttpStatus.OK);
    }
}
