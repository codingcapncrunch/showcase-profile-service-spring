package com.org.myapp.domain.service.contactus;

import com.org.myapp.domain.model.ContactUsRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class ContactUsServiceImpl implements ContactUsService{
    @Override
    public boolean submitContactUsRequest(ContactUsRequest contactUsRequest) {
        log.info("At submitContactUsRequest...{}", contactUsRequest.toString());
        return false;
    }
}
