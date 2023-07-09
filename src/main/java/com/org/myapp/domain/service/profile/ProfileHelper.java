package com.org.myapp.domain.service.profile;

import com.org.myapp.domain.model.Profile;
import org.springframework.util.StringUtils;

public class ProfileHelper {

    private static ProfileHelper INSTANCE;
    private ProfileHelper(){

    }

    public static ProfileHelper getInstance(){

        if (INSTANCE == null){
            INSTANCE = new ProfileHelper();
        }
        return INSTANCE;
    }

    public Profile profileToLowercase(Profile profile){

        if (profile != null) {
            if (StringUtils.hasLength(profile.getFirstName())) {
                profile.setFirstName(profile.getFirstName().toLowerCase());
            }
            if (StringUtils.hasLength(profile.getMiddleName())) {
                profile.setMiddleName(profile.getMiddleName().toLowerCase());
            }
            if (StringUtils.hasLength(profile.getLastName())) {
                profile.setLastName(profile.getLastName().toLowerCase());
            }
            if (StringUtils.hasLength(profile.getEmail())) {
                profile.setEmail(profile.getEmail().toLowerCase());
            }

            if (profile.getAddress()!=null){
                if (StringUtils.hasLength(profile.getAddress().getLineOne())){
                    profile.getAddress().setLineOne(profile.getAddress().getLineOne().toLowerCase());
                }
                if (StringUtils.hasLength(profile.getAddress().getLineTwo())){
                    profile.getAddress().setLineTwo(profile.getAddress().getLineTwo().toLowerCase());
                }
                if (StringUtils.hasLength(profile.getAddress().getCity())){
                    profile.getAddress().setCity(profile.getAddress().getCity().toLowerCase());
                }
            }

        }
        return profile;
    }
}
