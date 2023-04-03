package com.org.myapp.api.model;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class Address {

    @NotNull(message = "line one cannot be null")
    @Pattern(regexp = "[a-zA-Z0-9 ]*", message = "line one must not contain special characters")
    @Size(max = 40, message = "line one exceeds max length")
    private String lineOne;

    @Pattern(regexp = "[a-zA-Z0-9 ]*", message = "line two must not contain special characters")
    @Size(max = 40, message = "line two exceeds max length")
    private String lineTwo;

    @NotNull(message = "city cannot be null")
    @Pattern(regexp = "[a-zA-Z0-9 ]*", message = "city must not contain special characters")
    @Size(max = 40, message = "city exceeds max length")
    private String city;

    @NotNull(message = "state cannot be null")
    @Pattern(regexp = "[a-zA-Z0-9 ]*", message = "state must not contain special characters")
    @Size(max = 40, message = "state exceeds max length")
    private String state;

    @NotNull(message = "zip code cannot be null")
    @Max(value = 99999, message = "invalid seven digit zip code")
    @Min(value = 10000, message = "invalid seven digit zip code")
    private int zipCode;

}
