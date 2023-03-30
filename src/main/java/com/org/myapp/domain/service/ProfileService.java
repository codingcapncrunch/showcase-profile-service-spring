package com.org.myapp.domain.service;

import com.org.myapp.domain.model.Profile;

public interface ProfileService {

    Profile createProfile(Profile profile);

    Profile getProfile(String id);

    Profile updateProfile(Profile profile);

    void deleteProfile(String id);
}
