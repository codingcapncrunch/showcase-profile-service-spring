package com.org.myapp.domain.service;

import com.org.myapp.domain.model.Profile;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@ConditionalOnProperty(
        value="inMemoryProfileService",
        havingValue = "false"
)
public class ProfileServiceImpl implements ProfileService {

    @Override
    public Profile createProfile(Profile profile) {
        return null;
    }

    @Override
    public Profile getProfile(String id) {
        return null;
    }

    @Override
    public Profile updateProfile(Profile profile) {
        return null;
    }

    @Override
    public void deleteProfile(String id) {

    }
}
