package com.main.app.service.user;

import com.main.app.domain.model.Surgery;
import com.main.app.domain.model.user.User;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SurgeryService {

    List<Surgery> findAllByPatient(User patient, Pageable pageable);
    Surgery save(Surgery surgery);
}
