package com.org.myapp.domain.model;

import lombok.Data;

@Data
public class Profile {

    private String id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private Address address;

}
