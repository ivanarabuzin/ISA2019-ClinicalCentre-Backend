package com.main.app.domain.model;

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
public class Prices extends AbstractEntity {

    @NotNull
    private String description;

    @NotNull
    private double price;

    @ManyToOne
    private
}
