package com.cloud.OrbitApplication.repository;


import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;
import java.math.BigDecimal;

import com.cloud.OrbitApplication.model.Orbit;

@Repository
public interface OrbitRepository extends JpaRepository<Orbit, Long> {
	
	@Modifying
    @Transactional
    @Query("update Orbit orb set orb.latitude = :latitude, orb.longitude = :longitude where orb.satellite_id = :satelliteID")
    int controlOrbit(Long satelliteID, BigDecimal latitude, BigDecimal longitude);
	
	Optional<Orbit> findById(Long satelliteID);
}
