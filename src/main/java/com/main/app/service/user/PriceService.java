package com.main.app.service.user;

import com.main.app.domain.model.Clinic;
import com.main.app.domain.model.Price;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PriceService {

    List<Price> findAllByClinic(Clinic clinic, Pageable pageable);
    Price save(Price price);
}
