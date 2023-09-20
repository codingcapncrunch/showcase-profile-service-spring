package com.org.myapp.domain.service.contactus;

import com.org.myapp.config.exception.AppException;
import com.org.myapp.config.exception.ExceptionEnum;
import com.org.myapp.domain.model.ContactUsRequest;
import com.org.myapp.domain.model.ContactUsStatusEnum;
import com.org.myapp.utils.Utils;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Log4j2
public class ContactUsServiceImpl implements ContactUsService{

    private ContactUsDataStore contactUsDataStore;

    @Autowired
    public ContactUsServiceImpl(ContactUsDataStore contactUsDataStore) {
        this.contactUsDataStore = contactUsDataStore;
    }

    @Override
    public ContactUsRequest submitContactUsRequest(ContactUsRequest contactUsRequest) {

        try{
            contactUsRequest.setContactUsStatus(ContactUsStatusEnum.PENDING);

            ContactUsRequest savedContactUsRequest = this.contactUsDataStore.save(contactUsRequest);
            log.info("New contact us request saved with generated id {}", savedContactUsRequest.getId());
            return savedContactUsRequest;
        } catch (Exception e){
            log.error("Exception at submitContactUsRequest with contactUsRequest: {}, exception: {}", contactUsRequest.toString(), e.getMessage());
            Utils.throwException(new AppException(ExceptionEnum.CU1000, "ContactUs save error"));
        }
        return null;
    }

    @Override
    public ContactUsRequest getContactUsRequest(String id) {

        Optional<ContactUsRequest> existingContactUs = this.contactUsDataStore.findById(id);
        if (existingContactUs.isPresent()){
            return existingContactUs.get();
        } else {
            Utils.throwException(new AppException(ExceptionEnum.CU1001, "ContactUs not found with id "+id));
        }
        return null;
    }
}
