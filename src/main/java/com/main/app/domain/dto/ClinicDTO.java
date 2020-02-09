package com.main.app.domain.dto;

import javax.validation.constraints.NotNull;

import com.main.app.domain.model.Clinic;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ClinicDTO
{
    private Long id;
    private String name;
    private String address;
    private String description;
    private String city;
    private String phoneNumber;
    private double price;

    private double rateCount;
    private double rateSum;
    private double averageRate;

    public ClinicDTO(Clinic clinic) {
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
