package com.org.myapp.domain.service;

import com.org.myapp.config.exception.AppException;
import com.org.myapp.config.exception.ExceptionEnum;
import com.org.myapp.domain.model.Profile;
import com.org.myapp.utils.Utils;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Log4j2
@ConditionalOnProperty(
        value="sqlDataRepository",
        havingValue = "true"
)
public class ProfileServiceImpl implements ProfileService {

    private ProfileDataStore profileDataStore;

    @Autowired
    public ProfileServiceImpl(ProfileDataStore profileDataStore) {
        this.profileDataStore = profileDataStore;
    }

    @Override
    public Profile createProfile(Profile profile) {
        return this.profileDataStore.save(profile);
    }

    @Override
    public Profile getProfile(String id) {
        Optional<Profile> existingProfile = this.profileDataStore.findById(id);
        if (existingProfile.isPresent()){
            return existingProfile.get();
        } else {
            Utils.throwException(new AppException(ExceptionEnum.PR1000, "Profile not found for ID "+id));
        }
        return null;
    }

    @Override
    public Profile updateProfile(Profile profile) {
        Optional<Profile> existingProfile = this.profileDataStore.findById(profile.getId());
        if (existingProfile.isPresent()){
            return this.profileDataStore.save(profile);
        } else {
            Utils.throwException(new AppException(ExceptionEnum.PR1000, "Profile not found for ID "+profile.getId()));
        }
        return null;
    }

    @Override
    public void deleteProfile(String id) {
        Optional<Profile> existingProfile = this.profileDataStore.findById(id);
        if (existingProfile.isPresent()){
            this.profileDataStore.deleteById(id);
        } else {
            Utils.throwException(new AppException(ExceptionEnum.PR1000, "Profile not found for ID "+id));
        }
    }
}
