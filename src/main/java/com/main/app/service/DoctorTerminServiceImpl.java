package com.main.app.service;


import com.main.app.domain.model.AppointmentType;
import com.main.app.domain.model.DoctorTermin;
import com.main.app.repository.user.DoctorTerminRepository;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorTerminServiceImpl implements DoctorTerminService {

    private DoctorTerminRepository doctorTerminRepository;

    @Autowired
    public DoctorTerminServiceImpl(DoctorTerminRepository doctorTerminRepository) {
        this.doctorTerminRepository = doctorTerminRepository;
    }

    public List<DoctorTermin> findAllByType(AppointmentType type, String date) {

        List<DoctorTermin> termins = doctorTerminRepository.findAllByType(type);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate day = LocalDate.parse(date, dtf);
        LocalDate tomorrow = day.plusDays(1);
        List<DoctorTermin> result = new ArrayList<DoctorTermin>();

        Instant instantDay = day.atStartOfDay(ZoneId.of("Europe/Paris")).toInstant();
        Instant instantTomorrow = tomorrow.atStartOfDay(ZoneId.of("Europe/Paris")).toInstant();

        for(DoctorTermin termin: termins) {

            if(termin.getDate().toEpochMilli() > instantDay.toEpochMilli() &&  termin.getDate().toEpochMilli() < instantTomorrow.toEpochMilli()) {
                result.add(termin);
            }

        }

        return result;
    }
}
