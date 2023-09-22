package com.org.myapp.domain.service.addressValidator;

import com.org.myapp.config.exception.AppException;
import com.org.myapp.config.exception.ExceptionEnum;
import com.org.myapp.utils.Utils;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
@Log4j2
public class AddressValidatorServiceImpl implements AddressValidatorService {

    private AddressCityStateDataStore addressCityStateDataStore;
    private AddressZipCodeDataStore addressZipCodeDataStore;

    @Autowired
    public AddressValidatorServiceImpl(AddressCityStateDataStore addressCityStateDataStore, AddressZipCodeDataStore addressZipCodeDataStore) {
        this.addressCityStateDataStore = addressCityStateDataStore;
        this.addressZipCodeDataStore = addressZipCodeDataStore;
    }

    @Override
    public boolean isValidAddressCombination(String city, String state, int zipCode) {
        if (!StringUtils.hasLength(city)){
            Utils.throwException(new AppException(ExceptionEnum.AD1001, "city provided is null/empty"));
        }
        if (!StringUtils.hasLength(state)){
            Utils.throwException(new AppException(ExceptionEnum.AD1002, "state provided is null/empty"));
        }

        //is valid state
        String foundState = this.getUSStates().stream().filter(s -> state.equalsIgnoreCase(s)).findFirst().orElse(null);
        if (foundState==null){
            Utils.throwException(new AppException(ExceptionEnum.AD1002, "state provided: "+state));
        }

        //is valid zipCode for state
        Integer foundZipCode = this.getZipCodesByState(state).stream().filter(zc -> zipCode==zc).findFirst().orElse(null);
        if (foundZipCode==null){
            Utils.throwException(new AppException(ExceptionEnum.AD1005, "zipCode and state provided: "+zipCode+" : "+state));
        }

        //is valid city for state
        String foundCity = this.getCitiesByState(state).stream().filter(c -> c.equalsIgnoreCase(city)).findFirst().orElse(null);
        if (foundCity==null){
            Utils.throwException(new AppException(ExceptionEnum.AD1004, "city and state provided: "+city+" : "+state));
        }

        return true;
    }

    @Override
    @Cacheable("staticAddressData")
    public List<String> getUSStates() {
        return this.addressZipCodeDataStore.findAvailableDistinctStates();
    }

    @Override
    @Cacheable("staticAddressData")
    public List<String> getCitiesByState(String state) {
        if (StringUtils.hasLength(state)){
            return this.addressCityStateDataStore.findAvailableCitiesByState(state);
        } else {
            Utils.throwException(new AppException(ExceptionEnum.AD1000, "AddressValidatorImpl.getCitiesByState - Received null or empty state value"));
        }
        return null;
    }

    @Override
    @Cacheable("staticAddressData")
    public List<Integer> getZipCodesByState(String state) {
        if (StringUtils.hasLength(state)){
            return this.addressZipCodeDataStore.findAvailableZipCodeByState(state);
        } else {
            Utils.throwException(new AppException(ExceptionEnum.AD1000, "AddressValidatorImpl.getZipCodesByState - Received null or empty state value"));
        }
        return null;
    }
}
