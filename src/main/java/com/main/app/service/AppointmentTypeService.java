package com.main.app.service;

import com.main.app.domain.model.AppointmentType;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AppointmentTypeService {

    List<AppointmentType> findAll();
}
