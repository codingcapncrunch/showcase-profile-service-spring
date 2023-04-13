package com.org.myapp.api.translator;

import com.org.myapp.api.model.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProfileTranslator extends Translator<Profile, com.org.myapp.domain.model.Profile> {

    private AddressTranslator addressTranslator;

    @Autowired
    public ProfileTranslator(AddressTranslator addressTranslator) {
        this.addressTranslator = addressTranslator;
    }

    @Override
    public Profile toApiModel(com.org.myapp.domain.model.Profile domain) {
        Profile apiProfile = new Profile();
        if (domain!=null){
            apiProfile.setId(domain.getId());
            apiProfile.setFirstName(domain.getFirstName());
            apiProfile.setMiddleName(domain.getMiddleName());
            apiProfile.setLastName(domain.getLastName());
            apiProfile.setEmail(domain.getEmail());
            apiProfile.setCreateDateTime(domain.getCreateDateTime());
            apiProfile.setUpdateDateTime(domain.getUpdateDateTime());
            apiProfile.setAddress(this.addressTranslator.toApiModel(domain.getAddress()));
        }
        return apiProfile;
    }

    @Override
    public com.org.myapp.domain.model.Profile toDomainModel(Profile api) {
        com.org.myapp.domain.model.Profile domainProfile = new com.org.myapp.domain.model.Profile();
        if (api!=null){
            domainProfile.setId(api.getId());
            domainProfile.setFirstName(api.getFirstName());
            domainProfile.setMiddleName(api.getMiddleName());
            domainProfile.setLastName(api.getLastName());
            domainProfile.setEmail(api.getEmail());
            domainProfile.setCreateDateTime(api.getCreateDateTime());
            domainProfile.setUpdateDateTime(api.getUpdateDateTime());
            domainProfile.setAddress(this.addressTranslator.toDomainModel(api.getAddress()));
        }
        return domainProfile;
    }
}
