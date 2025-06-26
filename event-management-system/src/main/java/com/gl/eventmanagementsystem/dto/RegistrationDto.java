package com.gl.eventmanagementsystem.dto;

import com.gl.eventmanagementsystem.entity.RegistrationStatus;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationDto {
    private Long id;

    @NotBlank(message = "The name should not be NULL/BLANK!")
    @Size(min = 3, message = "The name must have at least 3 characters!")
    private String name;

    @NotBlank(message = "The email should not be NULL/BLANK!")
    @Email(message = "The email must be valid!")
    private String email;

    @NotBlank(message = "The contact number should not be NULL/BLANK!")
    @Size(min = 10, message = "The contact number must have at least 10 characters!")
    private String contactNumber;

    @NotNull(message = "The status should not be NULL!")
    private RegistrationStatus status;

    @NotNull(message = "Event ID should not be NULL!")
    @Positive(message = "Event ID must be a positive number!")
    private Long eventId;
}
