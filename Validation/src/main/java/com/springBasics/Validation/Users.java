package com.springBasics.Validation;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class Users {

    @NotBlank(message = "Name is mandatory")
    @Size(min = 2, max = 30, message = "Name must be between 2 and 30 characters")
    private String name;

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "Number is mandatory")
    @Pattern(regexp = "^\\d{10}$", message = "Number must be a valid 10-digit phone number")
    private String number;

    @NotBlank(message = "Password is mandatory")
    @Size(min = 8, message = "Password must be at least 8 characters long")
    private String password;

    @NotNull(message = "Date of Birth is mandatory")
    @Past(message = "Date of Birth must be a past date")
    private LocalDate dateOfBirth;

    public @NotBlank(message = "Name is mandatory") @Size(min = 2, max = 30, message = "Name must be between 2 and 30 characters") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "Name is mandatory") @Size(min = 2, max = 30, message = "Name must be between 2 and 30 characters") String name) {
        this.name = name;
    }

    public @NotBlank(message = "Email is mandatory") @Email(message = "Email should be valid") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "Email is mandatory") @Email(message = "Email should be valid") String email) {
        this.email = email;
    }

    public @NotBlank(message = "Number is mandatory") @Pattern(regexp = "^\\d{10}$", message = "Number must be a valid 10-digit phone number") String getNumber() {
        return number;
    }

    public void setNumber(@NotBlank(message = "Number is mandatory") @Pattern(regexp = "^\\d{10}$", message = "Number must be a valid 10-digit phone number") String number) {
        this.number = number;
    }

    public @NotBlank(message = "Password is mandatory") @Size(min = 8, message = "Password must be at least 8 characters long") String getPassword() {
        return password;
    }

    public void setPassword(@NotBlank(message = "Password is mandatory") @Size(min = 8, message = "Password must be at least 8 characters long") String password) {
        this.password = password;
    }

    public @NotNull(message = "Date of Birth is mandatory") @Past(message = "Date of Birth must be a past date") LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(@NotNull(message = "Date of Birth is mandatory") @Past(message = "Date of Birth must be a past date") LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}