package com.gl.eventmanagementsystem.service.impl;

import com.gl.eventmanagementsystem.dto.RegistrationDto;
import com.gl.eventmanagementsystem.dto.ResponseDto;
import com.gl.eventmanagementsystem.entity.Registration;
import com.gl.eventmanagementsystem.exception.ResourceNotFoundException;
import com.gl.eventmanagementsystem.repository.RegistrationRepository;
import com.gl.eventmanagementsystem.service.RegistrationService;
import com.gl.eventmanagementsystem.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    private RegistrationRepository registrationRepository;

    @Override
    public RegistrationDto register(RegistrationDto registrationDto) {
        Registration existing = registrationRepository.findByEmail(registrationDto.getEmail());
        if (existing != null) {
            throw new RuntimeException("Registration already exists with email: " + registrationDto.getEmail());
        }

        Registration registration = Mapper.mapToRegistration(registrationDto);
        registration = registrationRepository.save(registration);
        return Mapper.mapToRegistrationDto(registration);
    }

    @Override
    public RegistrationDto getRegistrationStatus(Long eventId, Long regId) {
        Registration registration = registrationRepository.findById(regId)
                .orElseThrow(() -> new ResourceNotFoundException("Registration", "registration_id", regId));

        if (!registration.getEvent().getId().equals(eventId)) {
            throw new ResourceNotFoundException("Event", "event_id", eventId);
        }

        return Mapper.mapToRegistrationDto(registration);
    }

    @Override
    public ResponseDto deleteRegistration(Long eventId, Long regId) {
        Registration registration = registrationRepository.findById(regId)
                .orElseThrow(() -> new ResourceNotFoundException("Registration", "registration_id", regId));

        if (!registration.getEvent().getId().equals(eventId)) {
            throw new ResourceNotFoundException("Event", "event_id", eventId);
        }

        registrationRepository.delete(registration);
        return new ResponseDto("The registration was successfully deleted");
    }
}
