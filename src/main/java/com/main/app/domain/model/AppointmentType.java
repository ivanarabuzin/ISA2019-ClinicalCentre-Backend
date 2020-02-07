package com.main.app.domain.model;

import com.main.app.domain.dto.AppointmentTypeDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class AppointmentType extends AbstractEntity {

    private String name;

    public AppointmentType(String name) {
        this.name = name;
    }

    public AppointmentType(AppointmentTypeDTO type) {
        this.id = type.getId();
        this.name = type.getName();
    }
}
