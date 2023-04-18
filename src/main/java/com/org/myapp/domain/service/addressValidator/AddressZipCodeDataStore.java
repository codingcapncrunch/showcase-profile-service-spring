package com.org.myapp.domain.service.addressValidator;

import com.org.myapp.domain.model.StateZipCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressZipCodeDataStore extends JpaRepository<StateZipCode, Integer> {

    @Query(value = "select distinct(state_short) from state_zipcode_tbl order by state_short", nativeQuery = true)
    List<String> findAvailableDistinctStates();

    @Query(value = "select zip_code from state_zipcode_tbl where state_short = ?1 order by zip_code", nativeQuery = true)
    List<Integer> findAvailableZipCodeByState(String state);
}
