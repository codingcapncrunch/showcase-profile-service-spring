package com.org.myapp.api.model;

import lombok.Data;

import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Data
public class ContactUsRequest {

    private String id;
    private String contactUsStatus;
    private LocalDateTime submittedDateTime;

    @NotBlank(message = "Message cannot be blank")
    @NotNull(message = "Message cannot be null")
    @Size(max = 250, message = "Message exceeds max length - 250 characters")
    private String message;

    @NotNull(message = "email cannot be null")
    @Email(message = "invalid email address")
    @Size(max = 40, message = "email exceeds max length - 40 characters")
    private String contactEmailAddress;

    @NotNull(message = "phone number cannot be null")
//    @Pattern(regexp="^\\d{10}$", message = "phone number must be 10 digits only")
    private int contactPhoneNumber;

    @NotNull(message = "country code cannot be null")
    @Max(value = 999, message = "invalid phone number country code")
    @Min(value = 1, message = "invalid phone number country code")
    private int contactPhoneNumberCountryCode;


}
