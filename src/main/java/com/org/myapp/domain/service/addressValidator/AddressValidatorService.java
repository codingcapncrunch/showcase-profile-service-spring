package com.org.myapp.domain.service.addressValidator;

import java.util.List;

public interface AddressValidatorService {

    boolean isValidAddressCombination(String city, String state, int zipCode);

    List<String> getUSStates();

    List<String> getCitiesByState(String state);

    List<Integer> getZipCodesByState(String state);

}
