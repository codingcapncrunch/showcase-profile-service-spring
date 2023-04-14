package com.org.myapp.domain.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class StateZipCode {

    @Id
    @Column(name = "zip_code")
    private int zipCode;

    @Column(name = "district_name")
    private String districtName;

    @Column(name = "state_short")
    private String stateShort;

}
