package com.main.app.service;

import com.main.app.domain.model.Clinic;
import com.main.app.domain.model.DoctorTermin;
import com.main.app.domain.model.HallTermin;
import com.main.app.repository.user.HallTerminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class HallTerminServiceImpl implements HallTerminService {

    private HallTerminRepository hallTerminRepository;

    @Autowired
    public HallTerminServiceImpl(HallTerminRepository hallTerminRepository) {
        this.hallTerminRepository = hallTerminRepository;
    }

    public List<HallTermin> findAllByClinicAndDate(String date, Clinic clinic) {

        List<HallTermin> terminsDatabase = hallTerminRepository.findAll();

        List<HallTermin> termins = new ArrayList<HallTermin>();

        for(HallTermin termin: terminsDatabase) {

            if(termin.getHall().getClinic().getId() == clinic.getId()) {
                termins.add(termin);
            }
        }

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate day = LocalDate.parse(date, dtf);
        LocalDate tomorrow = day.plusDays(1);
        List<HallTermin> result = new ArrayList<HallTermin>();

        Instant instantDay = day.atStartOfDay(ZoneId.of("Europe/Paris")).toInstant();
        Instant instantTomorrow = tomorrow.atStartOfDay(ZoneId.of("Europe/Paris")).toInstant();

        for(HallTermin termin: termins) {

            if(termin.getDate().toEpochMilli() > instantDay.toEpochMilli() &&
                    termin.getDate().toEpochMilli() < instantTomorrow.toEpochMilli()) {
                result.add(termin);
            }
        }

        return result;
    }

    public List<HallTermin> getFreeTerminsForClinic(long clinicId) {
        List<HallTermin> termins = hallTerminRepository.findAllByFree(true);

        List<HallTermin> result = new ArrayList<>();

        for(HallTermin termin: termins) {

            if(termin.getHall().getClinic().getId() == clinicId) {
                result.add(termin);
            }
        }

        return result;
    }

}
