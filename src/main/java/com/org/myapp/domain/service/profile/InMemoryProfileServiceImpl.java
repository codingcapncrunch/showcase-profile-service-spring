package com.org.myapp.domain.service.profile;

import com.org.myapp.api.model.SearchRequest;
import com.org.myapp.config.exception.AppException;
import com.org.myapp.config.exception.ExceptionEnum;
import com.org.myapp.domain.model.Profile;
import com.org.myapp.domain.model.SearchResponse;
import com.org.myapp.utils.Utils;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;

@Service
@Log4j2
@ConditionalOnProperty(
        value="inMemoryProfileService",
        havingValue = "true"
)
public class InMemoryProfileServiceImpl implements ProfileService {

    private Map<String, Profile> inMemoryProfileDB;

    @Autowired
    public InMemoryProfileServiceImpl() {
        this.inMemoryProfileDB = new HashMap<>();
    }

    @Override
    public Profile createProfile(Profile profile) {

        this.isValidProfileData(profile);
        String generatedId = UUID.randomUUID().toString();
        log.info("ProfileService - generating new uuid {} for profile.", generatedId);

        profile.setId(generatedId);
        this.inMemoryProfileDB.put(generatedId, ProfileHelper.getInstance().profileToLowercase(profile));
        return profile;

    }

    @Override
    public Profile getProfile(String id) {

        this.isValidProfileId(id);

        Optional<Profile> profile = Optional.ofNullable(this.inMemoryProfileDB.get(id));
        if (profile.isPresent()){
            return profile.get();
        } else {
            Utils.throwException(new AppException(ExceptionEnum.PR1000, "Profile ID attempted for get "+id));
        }
        return null;
    }

    @Override
    public Profile updateProfile(Profile profile) {

        Profile existingProfile;

        this.isValidProfileId(profile.getId());
        this.isValidProfileData(profile);

        existingProfile = this.getProfile(profile.getId());

        if (existingProfile!=null){
            // profile exists, update it
            existingProfile.setFirstName(profile.getFirstName());
            existingProfile.setMiddleName(profile.getMiddleName());
            existingProfile.setLastName(profile.getLastName());
            existingProfile.setEmail(profile.getEmail());

            if (profile.getAddress()!=null){
                //update address
                existingProfile.getAddress().setType(profile.getAddress().getType());
                existingProfile.getAddress().setLineOne(profile.getAddress().getLineOne());
                existingProfile.getAddress().setLineTwo(profile.getAddress().getLineTwo());
                existingProfile.getAddress().setCity(profile.getAddress().getCity());
                existingProfile.getAddress().setState(profile.getAddress().getState());
                existingProfile.getAddress().setZipCode(profile.getAddress().getZipCode());
            } else {
                //null address
                existingProfile.setAddress(null);
            }

            this.inMemoryProfileDB.put(existingProfile.getId(), ProfileHelper.getInstance().profileToLowercase(existingProfile));
            return existingProfile;

        } else {
            Utils.throwException(new AppException(ExceptionEnum.PR1000));
            return null;
        }

    }

    @Override
    public void deleteProfile(String id) {

        this.isValidProfileId(id);
        Profile existingProfile = this.inMemoryProfileDB.get(id);
        if (existingProfile!=null){
            this.inMemoryProfileDB.remove(id);
            log.info("ProfileService - profile id {} removed successfully", id);

        } else {
            Utils.throwException(new AppException(ExceptionEnum.PR1000, "Profile id provided: "+id));
        }
    }

    @Override
    public SearchResponse searchProfile(SearchRequest searchRequest) {
        //todo
        log.info("************* searchProfile not implemented at InMemoryProfileServiceImpl *************");
        return null;
    }

    private void isValidProfileId(String id) {
        if (!StringUtils.hasLength(id)){
            Utils.throwException(new AppException(ExceptionEnum.PR1001));
        }
    }

    private void isValidProfileData(Profile profile){
        //todo; additional data validation
        if (!StringUtils.hasLength(profile.getFirstName()) || !StringUtils.hasLength(profile.getLastName())){
            Utils.throwException(new AppException(ExceptionEnum.PR1002));
        }
    }

}
