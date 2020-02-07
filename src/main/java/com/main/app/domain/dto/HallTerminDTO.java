package com.main.app.domain.dto;

import com.main.app.domain.model.AppointmentType;
import com.main.app.domain.model.DoctorTermin;
import com.main.app.domain.model.Hall;
import com.main.app.domain.model.HallTermin;
import com.main.app.domain.model.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@NoArgsConstructor
@Getter
@Setter
public class HallTerminDTO {

    private Instant date;
    private HallDTO hall;
    private boolean free;
    private String time;

    public HallTerminDTO(HallTermin termin) {
        this.date = termin.getDate();
        this.hall = new HallDTO(termin.getHall());
        this.free = termin.isFree();
        this.time = termin.getTime();
    }
}
