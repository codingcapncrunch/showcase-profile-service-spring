package com.org.myapp.domain.service.contactus;

import com.org.myapp.domain.model.ContactUsRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class ContactUsServiceImpl implements ContactUsService{

    private ContactUsDataStore contactUsDataStore;

    @Autowired
    public ContactUsServiceImpl(ContactUsDataStore contactUsDataStore) {
        this.contactUsDataStore = contactUsDataStore;
    }

    @Override
    public boolean submitContactUsRequest(ContactUsRequest contactUsRequest) {

        try{
            ContactUsRequest savedContactUsRequest = this.contactUsDataStore.save(contactUsRequest);
            log.info("New contact us request saved with generated id {}", savedContactUsRequest.getId());
            return true;
        } catch (Exception e){
            log.error("Exception at submitContactUsRequest with contactUsRequest: {}, exception: {}", contactUsRequest.toString(), e.getMessage());
        }
        return false;
    }
}
