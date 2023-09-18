package com.org.myapp.domain.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ContactUsRequest {

    private String message;
    private LocalDateTime submittedDateTime;
    private String contactEmailAddress;
    private int contactPhoneNumber;
    private int contactPhoneNumberCountryCode;
}
