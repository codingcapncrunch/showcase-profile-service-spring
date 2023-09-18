package com.org.myapp.domain.service.contactus;

import com.org.myapp.domain.model.ContactUsRequest;

public interface ContactUsService {

    boolean submitContactUsRequest(ContactUsRequest contactUsRequest);

}
