package com.org.myapp.domain.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "address_tbl")
public class Address {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "type", length = 10)
    private AddressTypeEnum type;

    @Column(name = "line_one", length=40)
    private String lineOne;

    @Column(name = "line_two", length=40)
    private String lineTwo;

    @Column(name= "city", length = 40)
    private String city;

    @Column(name = "state", length = 40)
    private String state;

    @Column(name = "zip_code", length = 10)
    private int zipCode;

    @CreationTimestamp
    @Column(name = "create_datetime")
    private LocalDateTime createDateTime;

    @UpdateTimestamp
    @Column(name = "update_datetime")
    private LocalDateTime updateDateTime;

    @OneToOne(mappedBy = "address")
    private Profile profile;

}
