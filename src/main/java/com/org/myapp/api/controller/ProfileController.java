package com.org.myapp.api.controller;

import com.org.myapp.api.model.Profile;
import com.org.myapp.api.model.SearchRequest;
import com.org.myapp.api.translator.ProfileTranslator;
import com.org.myapp.api.translator.SearchTranslator;
import com.org.myapp.domain.model.SearchResponse;
import com.org.myapp.domain.service.profile.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value="/profile")
public class ProfileController {

    private SearchTranslator searchTranslator;
    private ProfileService profileService;
    private ProfileTranslator profileTranslator;

    @Autowired
    public ProfileController(SearchTranslator searchTranslator, ProfileService profileService, ProfileTranslator profileTranslator) {
        this.searchTranslator = searchTranslator;
        this.profileService = profileService;
        this.profileTranslator = profileTranslator;
    }

    //create
    @PostMapping
    public ResponseEntity createProfile(@RequestBody @Valid Profile profile){
        com.org.myapp.domain.model.Profile newProfile = this.profileService.createProfile(this.profileTranslator.toDomainModel(profile));
        return ResponseEntity.ok(newProfile!=null ? this.profileTranslator.toApiModel(newProfile): null);
    }

    //get
    @GetMapping
    @RequestMapping(value="/{id}")
    public ResponseEntity getProfile(@PathVariable String id){
        com.org.myapp.domain.model.Profile profile = this.profileService.getProfile(id);
        return ResponseEntity.ok(profile!=null ? this.profileTranslator.toApiModel(profile): null);
    }

    //update
    @PutMapping
    public ResponseEntity updateProfile(@RequestBody @Valid Profile profile){
        com.org.myapp.domain.model.Profile newProfile = this.profileService.updateProfile(this.profileTranslator.toDomainModel(profile));
        return ResponseEntity.ok(newProfile!=null ? this.profileTranslator.toApiModel(newProfile): null);
    }

    //delete
    @DeleteMapping
    @RequestMapping(value="/{id}/delete")
    public ResponseEntity deleteProfile(@PathVariable String id){
        this.profileService.deleteProfile(id);
        return ResponseEntity.ok("deleted");
    }

    //search
    @GetMapping
    @RequestMapping(value="/search")
    public ResponseEntity searchProfiles(@RequestBody SearchRequest searchRequest){
        SearchResponse searchResponse = this.profileService.searchProfile(searchRequest);
        return ResponseEntity.ok(searchResponse!=null ? this.searchTranslator.toApiModel(searchResponse) : null);
    }

}
