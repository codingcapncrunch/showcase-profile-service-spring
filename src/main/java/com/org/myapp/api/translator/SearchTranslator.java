package com.org.myapp.api.translator;

import com.org.myapp.api.model.SearchResponse;
import com.org.myapp.domain.model.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SearchTranslator extends Translator<SearchResponse, com.org.myapp.domain.model.SearchResponse>{

    private ProfileTranslator profileTranslator;

    @Autowired
    public SearchTranslator(ProfileTranslator profileTranslator) {
        this.profileTranslator = profileTranslator;
    }

    @Override
    public SearchResponse toApiModel(com.org.myapp.domain.model.SearchResponse domain) {

        SearchResponse searchResponse = new SearchResponse();

        if (domain!=null){
            searchResponse.setCount(domain.getCount());
            searchResponse.setSearchDateTime(domain.getSearchDateTime());

            List<com.org.myapp.api.model.Profile> apiProfiles = new ArrayList<>();
            for (Profile profile : domain.getProfiles()){
                apiProfiles.add(this.profileTranslator.toApiModel(profile));
            }
            searchResponse.setProfiles(apiProfiles);
        }

        return searchResponse;
    }

    @Override
    public com.org.myapp.domain.model.SearchResponse toDomainModel(SearchResponse api) {
        return null;
    }
}
