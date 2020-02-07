package com.main.app.service;


import com.main.app.domain.model.AppointmentType;
import com.main.app.domain.model.Clinic;
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

    public List<Clinic> findAllClinicsByType(AppointmentType type, String date, String city) {
        List<DoctorTermin> termins = this.findAllByType(type, date, city, null, "");
        List<Clinic> clinics = new ArrayList<Clinic>();

        for(DoctorTermin termin: termins) {

            if(!this.isContainsClinic(clinics, termin.getDoctor().getClinic())) {
                termin.getDoctor().getClinic().setPrice(termin.getPrice());
                clinics.add(termin.getDoctor().getClinic());
            }
        }

        return clinics;
    }

    public boolean isContainsClinic(List<Clinic> clinics, Clinic clinic) {

        for(Clinic compareClinic: clinics) {
            if(compareClinic.getId() == clinic.getId()) {
                return true;
            }
        }

        return false;
    }

    public List<DoctorTermin> findAllByType(AppointmentType type, String date, String city, Clinic clinic, String name) {

        List<DoctorTermin> termins = doctorTerminRepository.findAllByType(type);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate day = LocalDate.parse(date, dtf);
        LocalDate tomorrow = day.plusDays(1);
        List<DoctorTermin> result = new ArrayList<DoctorTermin>();

        Instant instantDay = day.atStartOfDay(ZoneId.of("Europe/Paris")).toInstant();
        Instant instantTomorrow = tomorrow.atStartOfDay(ZoneId.of("Europe/Paris")).toInstant();

        if(city.equals("null")) {
            city = "";
        }

        if(name == null || name.equals("null")) {
            name = "";
        }

        for(DoctorTermin termin: termins) {

            Clinic compareClinic = termin.getDoctor().getClinic();
            String compareCity = termin.getDoctor().getClinic().getCity().toLowerCase();
            String compareName = termin.getDoctor().getName().toLowerCase();
            String compareSurname = termin.getDoctor().getSurname().toLowerCase();

            if(!termin.isFree()) {
                continue;
            }

            if(!(compareName.contains(name.toLowerCase()) || compareSurname.contains(name.toLowerCase()))) {
                continue;
            }

            if(termin.getDate().toEpochMilli() > instantDay.toEpochMilli()
                    && (clinic == null || compareClinic.getId() == clinic.getId()) &&
                    termin.getDate().toEpochMilli() < instantTomorrow.toEpochMilli()
                    && compareCity.contains(city.toLowerCase())) {
                result.add(termin);
            }
        }

        return result;
    }
}
