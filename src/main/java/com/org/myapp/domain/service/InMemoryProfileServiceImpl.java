package com.org.myapp.domain.service;

import com.org.myapp.domain.model.Profile;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

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

        if (this.isValidCreate(profile)){
            String generatedId = UUID.randomUUID().toString();
            log.info("ProfileService - generating new uuid {} for profile.", generatedId);

            profile.setId(generatedId);
            this.inMemoryProfileDB.put(generatedId, profile);
            return profile;
        }
        log.error("ProfileService - createProfile request invalid!");
        return null;

    }

    @Override
    public Profile getProfile(String id) {

        if(this.isValidProfileId(id)){
            return this.inMemoryProfileDB.get(id);
        }
        log.error("ProfileService - getProfile request invalid!");
        return null;

    }

    @Override
    public Profile updateProfile(Profile profile) {

        Profile existingProfile;

        if (this.isValidProfileId(profile.getId())){
            existingProfile = this.getProfile(profile.getId());

            if (existingProfile!=null){
                // profile exists, update it
                existingProfile.setFirstName(profile.getFirstName());
                existingProfile.setLastName(profile.getLastName());

                if (profile.getAddress()!=null){
                    //update address
                    existingProfile.getAddress().setLineOne(profile.getAddress().getLineOne());
                    existingProfile.getAddress().setLineTwo(profile.getAddress().getLineTwo());
                    existingProfile.getAddress().setCity(profile.getAddress().getCity());
                    existingProfile.getAddress().setState(profile.getAddress().getState());
                    existingProfile.getAddress().setZipCode(profile.getAddress().getZipCode());
                } else {
                    //null address
                    existingProfile.setAddress(null);
                }

                this.inMemoryProfileDB.put(existingProfile.getId(), existingProfile);
                return existingProfile;

            } else {
                // profile doesn't not exist to update
                log.error("ProfileService - profile with id {} does not exist to be updated.", profile.getId());
                return null;
            }


        } else {
            log.error("ProfileService - profile not updated due to invalid profile ID.");
            return null;
        }
    }

    @Override
    public void deleteProfile(String id) {

        if (isValidProfileId(id)){
            Profile existingProfile = this.inMemoryProfileDB.get(id);
            if (existingProfile!=null){
                this.inMemoryProfileDB.remove(id);
                log.info("ProfileService - profile id {} removed successfully", id);

            } else {
                log.error("ProfileService - profile not found");
            }
        } else {
            log.error("ProfileService - could not delete profile");
        }

    }

    private boolean isValidProfileId(String id){
        if (StringUtils.isEmpty(id)){
            log.error("ProfileService - profile ID is empty/null");
            return false;
        }
        return true;
    }

    private boolean isValidCreate(Profile profile){

        if (StringUtils.isEmpty(profile.getId())){
            log.info("ProfileService - Profile data valid.");
            return true;
        } else {
            log.error("ProfileService - Profile data IS NOT valid.");
            return false;
        }
    }
}
