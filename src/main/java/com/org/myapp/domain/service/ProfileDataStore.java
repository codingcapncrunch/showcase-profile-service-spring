package com.org.myapp.domain.service;

import com.org.myapp.domain.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfileDataStore extends JpaRepository<Profile, String> {

//    @Query(
//            value = "select * from profile_tbl where email = ?1 order by update_datetime DESC limit ?2", nativeQuery = true
//    )
//    List<Profile> searchByEmail(String email, int limit);

    List<Profile> findTop10ByEmail(String email);

//    @Query(
//            value = "select * from profile_tbl where first_name like ?1% and last_name like ?2% order by last_name limit ?3", nativeQuery = true
//    )
//    List<Profile> searchByName(String firstName, String lastName, int limit);

    List<Profile> findByFirstNameContainsAndLastNameContaining(String firstName, String lastName);

}
