package com.org.myapp.domain.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SourceType;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "contactus_tbl")
public class ContactUsRequest {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String id;

    @Column(name = "message", length = 255)
    private String message;

    @CreationTimestamp
    @Column(name = "created_datetime")
    private LocalDateTime submittedDateTime;

    @Column(name = "email_address", length = 42)
    private String contactEmailAddress;

    @Column(name = "phone_number", length = 10)
    private int contactPhoneNumber;

    @Column(name = "phone_country_code", length = 3)
    private int contactPhoneNumberCountryCode;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private ContactUsStatusEnum contactUsStatus;

}
