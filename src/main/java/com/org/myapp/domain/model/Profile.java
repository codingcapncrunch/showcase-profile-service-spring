package com.org.myapp.domain.model;

import lombok.Data;

@Data
public class Profile {

    private String id;
    private String firstName;
    private String lastName;
    private Address address;

}
