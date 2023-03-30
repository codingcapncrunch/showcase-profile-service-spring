package com.org.myapp.api.model;

import lombok.Data;

@Data
public class Profile {

    private String id;
    private String firstName;
    private String lastName;
    private Address address;

}
