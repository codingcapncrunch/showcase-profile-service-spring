package com.org.myapp.domain.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "profile_tbl")
public class Profile {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String id;

    @Column(name = "first_name", length = 40)
    private String firstName;

    @Column(name = "middle_name", length = 40)
    private String middleName;

    @Column(name = "last_name", length = 40)
    private String lastName;

    @Column(name = "email", length = 40)
    private String email;

    @CreationTimestamp
    @Column(name = "create_datetime")
    private LocalDateTime createDateTime;

    @UpdateTimestamp
    @Column(name = "update_datetime")
    private LocalDateTime updateDateTime;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "profile_address_tbl",
            joinColumns =
                    { @JoinColumn(name = "profile_id", referencedColumnName = "id") },
            inverseJoinColumns =
                    { @JoinColumn(name = "address_id", referencedColumnName = "id") })
    private Address address;

}
