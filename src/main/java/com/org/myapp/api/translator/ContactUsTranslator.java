package com.org.myapp.api.translator;

import com.org.myapp.api.model.ContactUsRequest;
import org.springframework.stereotype.Component;

@Component
public class ContactUsTranslator extends Translator<ContactUsRequest, com.org.myapp.domain.model.ContactUsRequest> {

    @Override
    public ContactUsRequest toApiModel(com.org.myapp.domain.model.ContactUsRequest domain) {
        ContactUsRequest apiRequest = new ContactUsRequest();
        apiRequest.setMessage(domain.getMessage());
        apiRequest.setContactPhoneNumber(domain.getContactPhoneNumber());
        apiRequest.setContactPhoneNumberCountryCode(domain.getContactPhoneNumberCountryCode());
        apiRequest.setContactEmailAddress(domain.getContactEmailAddress());
        apiRequest.setId(domain.getId());
        apiRequest.setContactUsStatus(domain.getContactUsStatus().toString());
        return apiRequest;
    }

    @Override
    public com.org.myapp.domain.model.ContactUsRequest toDomainModel(ContactUsRequest api) {

        com.org.myapp.domain.model.ContactUsRequest domainRequest = new com.org.myapp.domain.model.ContactUsRequest();
        domainRequest.setMessage(api.getMessage());
        domainRequest.setContactPhoneNumber(api.getContactPhoneNumber());
        domainRequest.setContactPhoneNumberCountryCode(api.getContactPhoneNumberCountryCode());
        domainRequest.setContactEmailAddress(api.getContactEmailAddress());
        return domainRequest;
    }
}
