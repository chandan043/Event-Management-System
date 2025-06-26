package com.gl.eventmanagementsystem.controller;

import com.gl.eventmanagementsystem.dto.RegistrationDto;
import com.gl.eventmanagementsystem.dto.ResponseDto;
import com.gl.eventmanagementsystem.service.RegistrationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/registration")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    // Register for an event
    @PostMapping
    public ResponseEntity<RegistrationDto> register(@RequestBody @Valid RegistrationDto registrationDto) {
        RegistrationDto created = registrationService.register(registrationDto);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    // Get the registration status
    @GetMapping("/{eventId}/register-status/{regId}")
    public ResponseEntity<RegistrationDto> getRegistrationStatus(@PathVariable Long eventId, @PathVariable Long regId) {
        RegistrationDto status = registrationService.getRegistrationStatus(eventId, regId);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    // Delete a registration
    @DeleteMapping("/{eventId}/delete-register/{regId}")
    public ResponseEntity<ResponseDto> deleteRegistration(@PathVariable Long eventId, @PathVariable Long regId) {
        ResponseDto responseDto = registrationService.deleteRegistration(eventId, regId);
        return ResponseEntity.ok(responseDto);
    }
}
