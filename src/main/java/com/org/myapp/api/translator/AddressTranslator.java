package com.org.myapp.api.translator;

import com.org.myapp.api.model.Address;
import org.springframework.stereotype.Component;

@Component
public class AddressTranslator extends Translator<Address, com.org.myapp.domain.model.Address> {

    @Override
    public Address toApiModel(com.org.myapp.domain.model.Address domain) {
        Address apiAddress = new Address();
        if (domain!=null){
            apiAddress.setId(domain.getId());
            apiAddress.setType(domain.getType());
            apiAddress.setLineOne(domain.getLineOne());
            apiAddress.setLineTwo(domain.getLineTwo());
            apiAddress.setCity(domain.getCity());
            apiAddress.setState(domain.getState());
            apiAddress.setZipCode(domain.getZipCode());
            apiAddress.setCreateDateTime(domain.getCreateDateTime());
            apiAddress.setUpdateDateTime(domain.getUpdateDateTime());
        }
        return apiAddress;
    }

    @Override
    public com.org.myapp.domain.model.Address toDomainModel(Address api) {
        com.org.myapp.domain.model.Address domainAddress = new com.org.myapp.domain.model.Address();
        if (api!=null){
            domainAddress.setId(api.getId());
            domainAddress.setType(api.getType());
            domainAddress.setLineOne(api.getLineOne());
            domainAddress.setLineTwo(api.getLineTwo());
            domainAddress.setCity(api.getCity());
            domainAddress.setState(api.getState());
            domainAddress.setZipCode(api.getZipCode());
            domainAddress.setCreateDateTime(api.getCreateDateTime());
            domainAddress.setUpdateDateTime(api.getUpdateDateTime());
        }
        return domainAddress;
    }
}
