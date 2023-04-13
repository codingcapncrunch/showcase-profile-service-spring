package com.org.myapp.domain.service;

import com.org.myapp.api.model.SearchRequest;
import com.org.myapp.domain.model.Profile;
import com.org.myapp.domain.model.SearchResponse;

import java.util.List;

public interface ProfileService {

    Profile createProfile(Profile profile);

    Profile getProfile(String id);

    Profile updateProfile(Profile profile);

    void deleteProfile(String id);

    SearchResponse searchProfile(SearchRequest searchRequest);
}
