package com.main.app.domain.model;

import com.main.app.domain.dto.ClinicDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.Instant;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Clinic extends AbstractEntity {

    @NotNull
    private String name;

    private String address;

    private String description;

    private String city;

    private String phoneNumber;

    @Transient
    private double price;

    private double rateCount;

    private double rateSum;

    private double averageRate;

    public Clinic(@NotNull String name, @NotNull String address, String description) {
        this.name = name;
        this.address = address;
        this.description = description;
    }

    public Clinic(ClinicDTO clinic) {
        this.id = clinic.getId();
        this.name = clinic.getName();
        this.address = clinic.getAddress();
        this.description = clinic.getDescription();
        this.city = clinic.getCity();
        this.phoneNumber = clinic.getPhoneNumber();
        this.price = clinic.getPrice();
        this.rateCount = clinic.getRateCount();
        this.rateSum = clinic.getRateSum();
        this.averageRate = clinic.getAverageRate();
    }
}
