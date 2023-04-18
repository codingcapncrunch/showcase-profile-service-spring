package com.org.myapp.domain.service.addressValidator;

import com.org.myapp.domain.model.CityState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressCityStateDataStore extends JpaRepository<CityState, Integer> {

    @Query(value = "select distinct(city) from city_state_tbl where state_short = ?1 order by city", nativeQuery = true)
    List<String> findAvailableCitiesByState(String state);

}
