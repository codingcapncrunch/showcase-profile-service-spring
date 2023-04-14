package com.org.myapp.domain.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class CityState {

    @Id
    private int id;

    @Column
    private String city;

    @Column(name = "state_short")
    private String stateShort;

    @Column(name = "state_full")
    private String stateFull;

    @Column
    private String county;

}
