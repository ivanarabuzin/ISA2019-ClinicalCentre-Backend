package com.main.app.controller;

import com.main.app.domain.dto.Entities;
import com.main.app.service.AppointmentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/appointmentType")
public class AppointmentTypeController {

    private AppointmentTypeService appointmentTypeService;

    @Autowired
    public AppointmentTypeController(AppointmentTypeService appointmentTypeService) {
        this.appointmentTypeService = appointmentTypeService;
    }

    @GetMapping(path = "/")
    public ResponseEntity<Entities> getAllTypes() {

        Entities result = new Entities();
        result.setEntities(appointmentTypeService.findAll());

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
