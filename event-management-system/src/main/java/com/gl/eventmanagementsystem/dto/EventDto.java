package com.gl.eventmanagementsystem.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

/*
    * Add the appropriate annotation for the fields to handle the validation
      using hibernate validator. Requirements are:
      * event name should not be null and should have a minimum of 3 characters
      * event date should not be null
      * location should not be null and should have a minimum of 3 characters
 */

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EventDto {
    private Long id;

    @NotBlank(message = "The eventName should not be NULL/BLANK!")
    @Size(min = 3, message = "The eventName must have at least 3 characters!")
    private String eventName;
    @NotNull(message = "The eventDate should not be NULL!")
    private String eventDate;
    @NotBlank(message = "The location should not be NULL/BLANK!")
    @Size(min = 3, message = "The location must have at least 3 characters!")
    private String location;
    @NotNull(message = "The registrations should not be NULL!")
    private List<RegistrationDto> registrations;
}
