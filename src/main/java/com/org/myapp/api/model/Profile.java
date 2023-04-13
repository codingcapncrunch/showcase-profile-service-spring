package com.org.myapp.api.model;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class Profile {

    @Pattern(regexp = "^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$", message = "must not contain special characters")
    @Size(min = 36, max = 36, message = "invalid id format")
    private String id;

    @NotNull(message = "first name cannot be null")
    @Pattern(regexp = "[a-zA-Z]*", message = "first name must not contain special characters nor spaces")
    @Size(max = 40, message = "first name exceeds max length")
    private String firstName;

    @Pattern(regexp = "[a-zA-Z]*", message = "middle name must not contain special characters nor spaces")
    @Size(max = 40, message = "middle name exceeds max length")
    private String middleName;

    @NotNull(message = "last name cannot be null")
    @Pattern(regexp = "[a-zA-Z]*", message = "last name must not contain special characters nor spaces")
    @Size(max = 40, message = "last name exceeds max length")
    private String lastName;

    @NotNull(message = "email cannot be null")
    @Email(message = "invalid email address")
    @Size(max = 40, message = "email exceeds max length")
    private String email;

    @Valid
    @NotNull(message = "address cannot be null")
    private Address address;

}
