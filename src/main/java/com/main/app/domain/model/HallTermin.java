package com.main.app.domain.model;

import com.main.app.domain.dto.DoctorTerminDTO;
import com.main.app.domain.dto.HallTerminDTO;
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
public class HallTermin extends AbstractEntity {

    private Instant date;

    @ManyToOne
    private Hall hall;

    private boolean free;

    private String time;

    public HallTermin(HallTerminDTO termin) {

        this.date = termin.getDate();
        this.hall = new Hall(termin.getHall());
        this.free = termin.isFree();
        this.time = termin.getTime();
    }

}
