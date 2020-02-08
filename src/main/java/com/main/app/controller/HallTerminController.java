package com.main.app.controller;

import com.main.app.domain.dto.Entities;
import com.main.app.domain.model.Clinic;
import com.main.app.domain.model.DoctorTermin;
import com.main.app.domain.model.HallTermin;
import com.main.app.repository.user.ClinicRepository;
import com.main.app.service.HallTerminService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/hallTermin")
public class HallTerminController {

    private HallTerminService hallTerminService;
    private ClinicRepository clinicRepository;

    public HallTerminController(HallTerminService hallTerminService, ClinicRepository clinicRepository) {

        this.hallTerminService = hallTerminService;
        this.clinicRepository = clinicRepository;
    }

    @GetMapping(path = "/{clinicId}/{date}")
    public ResponseEntity<Entities> getFreeHalles(@PathVariable long clinicId, @PathVariable String date) {
        Optional<Clinic> clinic = clinicRepository.findById(clinicId);

        Entities entities = new Entities();

        entities.setEntities(hallTerminService.findAllByClinicAndDate(date, clinic.get()));

        return new ResponseEntity<>(entities, HttpStatus.OK);
    }

    @GetMapping(path = "/free/{clinicId}")
    public ResponseEntity<Entities> getFreeTerminsForClinic(@PathVariable long clinicId) {

        List<HallTermin> termins = hallTerminService.getFreeTerminsForClinic(clinicId);

        Entities entities = new Entities();

        entities.setEntities(termins);

        return new ResponseEntity<>(entities, HttpStatus.OK);
    }
}
