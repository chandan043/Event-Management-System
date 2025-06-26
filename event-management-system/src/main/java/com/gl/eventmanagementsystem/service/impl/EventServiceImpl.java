package com.gl.eventmanagementsystem.service.impl;


import com.gl.eventmanagementsystem.dto.EventDto;
import com.gl.eventmanagementsystem.dto.RegistrationDto;
import com.gl.eventmanagementsystem.dto.ResponseDto;
import com.gl.eventmanagementsystem.entity.Event;
import com.gl.eventmanagementsystem.entity.Registration;
import com.gl.eventmanagementsystem.exception.ResourceNotFoundException;
import com.gl.eventmanagementsystem.repository.EventRepository;
import com.gl.eventmanagementsystem.service.EventService;
import com.gl.eventmanagementsystem.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    EventRepository eventRepository;

    @Override
    public EventDto createEvent(EventDto eventDto) {
        Event event = Mapper.mapToEvent(eventDto);
        List<RegistrationDto> registrationDtos = eventDto.getRegistrations();
        List<Registration> registrationList= new ArrayList<>();
        for(RegistrationDto registrationDto: registrationDtos){
            Registration registration = Mapper.mapToRegistration(registrationDto);
            registrationList.add(registration);
        }
        event.setRegistrationList(registrationList);
        eventRepository.save(event);
        return eventDto;
    }

    @Override
    public EventDto getEvent(Long eventId) {
        Optional<Event> optionalEvent = eventRepository.findById(eventId);
        if (!optionalEvent.isPresent()) {
            throw new ResourceNotFoundException("Event","EventId",eventId);
        }
        return Mapper.mapToEventDto(optionalEvent.get());
    }

    @Override
    public List<EventDto> getAllEvents() {
        List<Event> eventList = eventRepository.findAll();
        List<EventDto> eventDtoList = new ArrayList<>();

        for(Event event : eventList){
            eventDtoList.add(Mapper.mapToEventDto(event));
        }
        return eventDtoList;
    }

    @Override
    public ResponseDto cancelEvent(Long eventId) {
        Optional<Event> optionalEvent = eventRepository.findById(eventId);
        if(!optionalEvent.isPresent())
            throw new ResourceNotFoundException("Event","EventId",eventId);
        eventRepository.delete(optionalEvent.get());
        return new ResponseDto("The Event Was Successfully Deleted");
    }
}
