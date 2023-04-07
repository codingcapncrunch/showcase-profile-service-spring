package com.org.myapp.domain.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@Table(name = "PROFILE_TBL")
public class Profile {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String id;

    @Column(name = "FIRST_NAME", length = 40, nullable = false)
    private String firstName;

    @Column(name = "MIDDLE_NAME", length = 40, nullable = true)
    private String middleName;

    @Column(name = "LAST_NAME", length = 40, nullable = false)
    private String lastName;

    @Column(name = "EMAIL", length = 40, nullable = false)
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "profile_address_tbl",
            joinColumns =
                    { @JoinColumn(name = "profile_id", referencedColumnName = "id") },
            inverseJoinColumns =
                    { @JoinColumn(name = "address_id", referencedColumnName = "id") })
    private Address address;

}
