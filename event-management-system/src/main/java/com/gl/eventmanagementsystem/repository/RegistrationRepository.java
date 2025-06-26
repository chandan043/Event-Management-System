package com.gl.eventmanagementsystem.repository;

import com.gl.eventmanagementsystem.entity.Registration;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;

// make this into a registration repository
public interface RegistrationRepository  extends JpaRepository<Registration,Long>{
    Registration findByEmail(@NotBlank(message = "The email should not be NULL/BLANK!") @Email(message = "The email must be valid!") String email);
    // create a method to check if a user exists by email
}
