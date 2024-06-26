package com.org.myapp.domain.service.profile;

import com.org.myapp.api.model.SearchRequest;
import com.org.myapp.config.exception.AppException;
import com.org.myapp.config.exception.ExceptionEnum;
import com.org.myapp.domain.model.Profile;
import com.org.myapp.domain.model.SearchResponse;
import com.org.myapp.domain.service.addressValidator.AddressValidatorService;
import com.org.myapp.utils.Utils;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Log4j2
@ConditionalOnProperty(
        value="sqlDataRepository",
        havingValue = "true"
)
public class ProfileServiceImpl implements ProfileService {

    @Value("${profile.search.limit}")
    private int searchLimit;
    private ProfileDataStore profileDataStore;
    private AddressValidatorService addressValidatorService;

    @Autowired
    public ProfileServiceImpl(ProfileDataStore profileDataStore, AddressValidatorService addressValidatorService) {
        this.profileDataStore = profileDataStore;
        this.addressValidatorService = addressValidatorService;
    }

    @Override
    public Profile createProfile(Profile profile) {

        this.isValidAddress(profile);

        if (this.addressValidatorService.isValidAddressCombination(profile.getAddress().getCity(), profile.getAddress().getState(), profile.getAddress().getZipCode())){
            return this.profileDataStore.save(ProfileHelper.getInstance().profileToLowercase(profile));
        }
        return null;
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

        if (profile.getId().isEmpty()){
            Utils.throwException(new AppException(ExceptionEnum.PR1001, "Update profile does not have a profile id."));
        }

        this.isValidAddress(profile);

        if (this.addressValidatorService.isValidAddressCombination(profile.getAddress().getCity(), profile.getAddress().getState(), profile.getAddress().getZipCode())){

            Optional<Profile> existingProfile = this.profileDataStore.findById(profile.getId());

            if (existingProfile.isPresent()){

                if (!existingProfile.get().getUpdateDateTime().equals(profile.getUpdateDateTime())){
                    Utils.throwException(new AppException(ExceptionEnum.PR1005, "Profile update timestamp does not match - dirty write error for id "+profile.getId()));
                }

                return this.profileDataStore.save(ProfileHelper.getInstance().profileToLowercase(profile));
            } else {
                Utils.throwException(new AppException(ExceptionEnum.PR1000, "Profile not found for ID "+profile.getId()));
            }
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

    @Override
    public SearchResponse searchProfile(SearchRequest searchRequest) {
        //Note on search criteria; prioritize email, first and last name, then zip


        if (searchRequest!=null){
            SearchResponse searchResponse = new SearchResponse();
            LocalDateTime searchDateTime = LocalDateTime.now();

            if (StringUtils.hasLength(searchRequest.getEmail())){

                log.info("ProfileServiceImpl.searchProfile - email searchRequest");
                List<Profile> profiles = this.profileDataStore.findTop10ByEmail(searchRequest.getEmail());
                searchResponse.setCount(profiles.size());
                searchResponse.setProfiles(profiles);
                searchResponse.setSearchDateTime(searchDateTime);
                return searchResponse;

            } else if(StringUtils.hasLength(searchRequest.getFirstName()) && StringUtils.hasLength(searchRequest.getLastName())){

                log.info("ProfileServiceImpl.searchProfile - first and last name searchRequest");
                List<Profile> profiles = this.profileDataStore.findByFirstNameContainsAndLastNameContaining(searchRequest.getFirstName(), searchRequest.getLastName());
                searchResponse.setCount(profiles.size());
                searchResponse.setProfiles(profiles);
                searchResponse.setSearchDateTime(searchDateTime);
                return searchResponse;

            } else if(searchRequest.getZipCode()!=null){

                log.info("ProfileServiceImpl.searchProfile - zip code searchRequest");
                //todo

                return searchResponse;

            } else {
                log.error("ProfileServiceImpl.searchProfile - unknown/invalid searchRequest");
            }

        } else {
            log.error("ProfileServiceImpl.searchProfile - null searchRequest");
        }

        Utils.throwException(new AppException(ExceptionEnum.PR1004));
        return null;
    }

    // test what javax validator isn't testing
    private void isValidAddress(Profile profile){

        if (profile.getAddress()!=null){
            String lineTwo = profile.getAddress().getLineTwo();

            if (!lineTwo.isEmpty() && lineTwo.trim().isEmpty()){
                Utils.throwException(new AppException(ExceptionEnum.AD1006));
            }
        }
    }

}
