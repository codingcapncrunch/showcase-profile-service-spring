package com.org.myapp.api.model;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class SearchRequest {

    // by first and lastname only
    @Pattern(regexp = "[a-zA-Z]*", message = "first name must not contain special characters nor spaces")
    @Size(max = 40, message = "first name exceeds max length")
    private String firstName;

    @Pattern(regexp = "[a-zA-Z]*", message = "last name must not contain special characters nor spaces")
    @Size(max = 40, message = "last name exceeds max length")
    private String lastName;

    // by email only
    @Email(message = "invalid email address")
    @Size(max = 40, message = "email exceeds max length")
    private String email;

    // by zipCode only
    @Max(value = 99999, message = "invalid seven digit zip code")
    @Min(value = 10000, message = "invalid seven digit zip code")
    private Integer zipCode;

}
