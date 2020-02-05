package com.main.app.domain.model;

import com.main.app.domain.dto.DoctorTerminDTO;
import com.main.app.domain.model.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.Instant;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class DoctorTermin extends AbstractEntity{

    private Instant date;

    @ManyToOne
    private User doctor;

    private boolean free;

    private double price;

    private String time;

    @ManyToOne
    AppointmentType type;

    public DoctorTermin(DoctorTerminDTO termin) {

        this.date = termin.getDate();
        this.doctor = termin.getDoctor();
        this.free = termin.isFree();
        this.type = termin.getType();
        this.price = termin.getPrice();
        this.time = termin.getTime();
    }
}
