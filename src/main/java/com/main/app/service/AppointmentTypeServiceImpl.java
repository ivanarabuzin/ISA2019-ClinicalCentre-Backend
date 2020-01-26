package com.main.app.service;

import com.main.app.domain.model.AppointmentType;
import com.main.app.repository.user.AppointmentRepository;
import com.main.app.repository.user.AppointmentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentTypeServiceImpl implements AppointmentTypeService {

    private AppointmentTypeRepository appointmentTypeRepository;

    @Autowired
    public AppointmentTypeServiceImpl(AppointmentTypeRepository appointmentTypeRepository) {
        this.appointmentTypeRepository = appointmentTypeRepository;
    }

    @Override
    public List<AppointmentType> findAll() {
        return appointmentTypeRepository.findAll();
    }
}
