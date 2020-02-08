package com.main.app.domain.dto;

import com.main.app.domain.model.AppointmentType;
import com.main.app.domain.model.DoctorTermin;
import com.main.app.domain.model.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.ManyToOne;
import java.time.Instant;

@NoArgsConstructor
@Getter
@Setter
public class DoctorTerminDTO {

    private Instant date;
    private User doctor;
    private boolean free;
    AppointmentType type;
    private double price;
    private String time;
    private String description;

    public DoctorTerminDTO(DoctorTermin termin) {
        this.date = termin.getDate();
        this.doctor = termin.getDoctor();
        this.free = termin.isFree();
        this.type = termin.getType();
        this.price = termin.getPrice();
        this.time = termin.getTime();

        this.description = termin.getDoctor().getName() + " " + termin.getDoctor().getSurname() + " " + termin.getDate() + " " + termin.getTime();
    }
}
