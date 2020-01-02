package com.main.app.controller;

import com.main.app.domain.dto.Entities;
import com.main.app.domain.dto.SurgeryDTO;
import com.main.app.domain.model.Surgery;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;

@RestController
@RequestMapping("/api/surgery")
public class SurgeryController {



    @GetMapping(path="/")
    public ResponseEntity<Entities> getAllBySearchParam(Pageable pageable, @RequestParam(name = "term") String term) {

        Entities result = dispatcherService.getAllBySearchParam(term, pageable);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping(path="/")
    public ResponseEntity<SurgeryDTO> add(@RequestBody SurgeryDTO surgeryDTO) {

        Surgery saved = dispatcherService.save(new Surgery(surgeryDTO));
        return new ResponseEntity<>(new SurgeryDTO(saved), HttpStatus.OK);
    }
}
