package com.gl.eventmanagementsystem.service;

import com.gl.eventmanagementsystem.dto.RegistrationDto;
import com.gl.eventmanagementsystem.dto.ResponseDto;

public interface RegistrationService {
    // It is responsible for registering for an event.
    RegistrationDto register(RegistrationDto registrationDto);
    // It is responsible for getting the registration status from the database using the eventId and regId.
    RegistrationDto getRegistrationStatus(Long eventId,Long regId);
    // It is responsible for deleting the registration from the database using the eventId and regId.
    ResponseDto deleteRegistration(Long eventId, Long regId);
}
