package com.example.Repositories;

import com.example.Models.HubMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface HubRepository extends JpaRepository<HubMaster, Long> {

    List<HubMaster> findByCity_CityId(Long cityId);

    @Query(value="select * from hub_master where airport_id = (select airport_id from airport_master where airport_code = :acd)" , nativeQuery = true)
    List<HubMaster> findByAirportCode(@Param("acd")String airportCode);

}
