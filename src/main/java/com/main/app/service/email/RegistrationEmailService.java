package com.main.app.service.email;

import org.springframework.stereotype.Service;

@Service
public interface RegistrationEmailService {

    void sendEmail(String url, String pathParam, String emailFrom, String emailTo, String urlPart);
    void sendDeclineEmail(String emailFrom, String emailTo, String message);

    void sendAdminAppointmentNotification(String emailFrom, String emailTo, String message);
    void sendBasicEmail(String emailFrom, String emailTo, String message, String subject);
}

