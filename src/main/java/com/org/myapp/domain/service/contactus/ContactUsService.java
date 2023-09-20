package com.org.myapp.domain.service.contactus;

import com.org.myapp.domain.model.ContactUsRequest;

import java.util.Optional;

public interface ContactUsService {

    ContactUsRequest submitContactUsRequest(ContactUsRequest contactUsRequest);

    ContactUsRequest getContactUsRequest(String id);

}
