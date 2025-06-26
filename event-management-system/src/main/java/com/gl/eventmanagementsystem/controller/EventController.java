package com.gl.eventmanagementsystem.controller;

import com.gl.eventmanagementsystem.dto.EventDto;
import com.gl.eventmanagementsystem.dto.ResponseDto;
import com.gl.eventmanagementsystem.service.EventService;
import com.gl.eventmanagementsystem.service.impl.EventServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {

    @Autowired
    EventServiceImpl eventService;
    // Add an event
    @GetMapping("/register")
    public ResponseEntity<EventDto> createEvent(@RequestBody @Valid EventDto eventDto) {
        EventDto eventDto1 = eventService.createEvent(eventDto);
        return new ResponseEntity<>(eventDto1,HttpStatus.OK);
    }

    // Get all events
    @GetMapping()
    public ResponseEntity<List<EventDto>>  getAllEvents() {
        List<EventDto> eventDtoList = eventService.getAllEvents();
        return ResponseEntity.ok(eventDtoList);
    }

    // Get an event by ID
    @GetMapping("/{eventId}")
    public ResponseEntity<EventDto> getEvent(@PathVariable Long eventId) {
        EventDto eventDto = eventService.getEvent(eventId);
        return new ResponseEntity<>(eventDto,HttpStatus.OK);
    }

    // Cancel an event
    @DeleteMapping("/delete/{eventId}")
    public  ResponseEntity<ResponseDto> cancelEvent(@PathVariable Long eventId) {
        ResponseDto responseDto = eventService.cancelEvent(eventId);
        return ResponseEntity.ok(responseDto);
    }

}
