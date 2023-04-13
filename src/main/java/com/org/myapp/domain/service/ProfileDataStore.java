package com.org.myapp.domain.service;

import com.org.myapp.domain.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileDataStore extends JpaRepository<Profile, String> {

}
