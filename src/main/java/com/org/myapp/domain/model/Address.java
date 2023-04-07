package com.org.myapp.domain.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "ADDRESS_TBL")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "TYPE", length = 10, nullable = false)
    private AddressTypeEnum type;

    @Column(name = "LINE_ONE", length=40, nullable=false)
    private String lineOne;

    @Column(name = "LINE_TWO", length=40, nullable = true)
    private String lineTwo;

    @Column(name= "CITY", length = 40, nullable = false)
    private String city;

    @Column(name = "STATE", length = 40, nullable = false)
    private String state;

    @Column(name = "ZIP_CODE", length = 10, nullable = false)
    private int zipCode;

    @OneToOne(mappedBy = "address")
    private Profile profile;

}
