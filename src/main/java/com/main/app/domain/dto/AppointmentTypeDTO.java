package com.main.app.domain.dto;

import com.main.app.domain.model.Appointment;
import com.main.app.domain.model.AppointmentType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class AppointmentTypeDTO {

    private long id;
    private String name;

    public AppointmentTypeDTO(AppointmentType type) {
        this.id = type.getId();
        this.name = type.getName();
    }
}
